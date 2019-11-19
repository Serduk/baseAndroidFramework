package com.sserdiuk.baseadroidframework.screens.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.data.SearchItemModel
import com.sserdiuk.baseadroidframework.screens.App
import com.sserdiuk.baseadroidframework.screens.BaseActivity
import com.sserdiuk.baseadroidframework.screens.foodDetails.FoodActivity

class SearchActivity : BaseActivity(), SearchCallbacks, SearchRouter, FoodItemsAdapter.ListItemClickListener {
    companion object {
        const val BAR_CODE = "BAR_CODE"
    }

    private val presenter: SearchPresenter = SearchPresenter()

    private lateinit var viewAdapter: FoodItemsAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var etSearchField: EditText

    private lateinit var pbLoader: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvErrorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)
        etSearchField = findViewById(R.id.etTypeForSearch)
        tvErrorMessage = findViewById(R.id.message)
        pbLoader = findViewById(R.id.pbSearch)

        viewManager = LinearLayoutManager(this)
        viewAdapter = FoodItemsAdapter(this)
        recyclerView = findViewById<RecyclerView>(R.id.itemsList).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        presenter.run {
            takeView(this@SearchActivity)
            takeRouter(this@SearchActivity)
            if (intent.hasExtra(BAR_CODE)) onTakeBarcode(intent?.extras?.getString(BAR_CODE))
            else onActivityOpen()
        }

        etSearchField.run {
            setOnKeyListener(object : View.OnKeyListener {
                override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                    if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                        searchItems()
                        hideKeyboard()
                        return true
                    }
                    return false
                }
            })
        }
    }

    override fun openItem(itemPath: String) {
        val intent = Intent(this, FoodActivity::class.java)
        intent.putExtra(FoodActivity.ITEM_NAME, itemPath)
        startActivity(intent)
    }

    override fun searchItems() {
        presenter.searchByText(etSearchField.text.toString())
    }

    override fun setTextInSearchField(text: String) {
        etSearchField.setText(text)
    }

    override fun showSearchResults(items: List<SearchItemModel>) {
        viewAdapter.setItems(items)
        recyclerView.visibility = VISIBLE
    }

    override fun showErrorMessage(text: String) {
        tvErrorMessage.text = text
        tvErrorMessage.visibility = VISIBLE
    }

    override fun onItemClick(position: Int) {
        presenter.onItemClicked(position)
    }

    override fun showProgressBar() {
        pbLoader.visibility = VISIBLE
    }

    override fun hideProgressBar() {
        pbLoader.visibility = GONE
    }

    override fun hideResults() {
        recyclerView.visibility = GONE
    }

    override fun hideErrorMessage() {
        tvErrorMessage.visibility = GONE
    }

    override fun requestSearchFocus() {
        etSearchField.requestFocus()
    }

    override fun showWarning(message: String) {
        App.showToast(message = message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.run {
            dropView()
            dropRouter()
        }
    }

    private fun View.hideKeyboard() {
        val iManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        iManager.hideSoftInputFromWindow(windowToken, 0)
    }
}
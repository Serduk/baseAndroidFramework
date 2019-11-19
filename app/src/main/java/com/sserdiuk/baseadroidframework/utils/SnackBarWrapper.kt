package com.sserdiuk.baseadroidframework.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar
import com.sserdiuk.baseadroidframework.R

/**
 * Wrapper for default SnackBar
 * Example, how we can use it:
 * <pre>{@code
 *       SnackbarWrapper.Companion.builder(R.layout.bottom_dialog_layout,
 *          findViewById(R.id.questions_list_activity_layout))
 *           .duration(SnackbarWrapper.Builder.Duration.LONG)
 *           .build()
 *           .show();
 *           }
 * </pre>
 *
 * Also, you can see put some additional data as parameter to xml in SnackBar,
 * see example:
 * <pre>
 *         override fun showOnErrorSnackBar(message: String?) {
 *              SnackbarWrapper.builder(R.layout.snackbar_get_ride_server_error, root)
 *                  .duration(SnackbarWrapper.Builder.Duration.LONG)
 *                  .build().also { wrapper -> message?.let { wrapper.contentView.textView.text = it } }
 *                  .show()
}
</pre>
 */

class SnackbarWrapper private constructor(val snackBar: Snackbar, val contentView: View) {
    val isShown: Boolean; get() = snackBar.isShown
    fun show() = snackBar.show()
    fun dismiss() = snackBar.dismiss()

    companion object {
        fun builder(@LayoutRes layoutRes: Int, view: View) = Builder(layoutRes, view)
    }

    class Builder(@LayoutRes private val layoutRes: Int, private val view: View) {
        private var backgroundRes: Int = -1
        private var duration: Duration = Duration.SHORT
        private var swipe: Boolean = true

        fun background(backgroundRes: Int) = apply { this.backgroundRes = backgroundRes }

        fun duration(duration: Duration) = apply { this.duration = duration }

        fun swipe(swipe: Boolean) = apply { this.swipe = swipe }

        fun build(): SnackbarWrapper {
            val snackbar = Snackbar.make(
                view, "", when (duration) {
                    Duration.INDEFINITE -> Snackbar.LENGTH_INDEFINITE
                    Duration.SHORT -> Snackbar.LENGTH_SHORT
                    Duration.LONG -> Snackbar.LENGTH_LONG
                }
            )
            return SnackbarWrapper(snackbar, with(snackbar.view as Snackbar.SnackbarLayout) {
                if (!swipe) {
                    viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                        override fun onPreDraw(): Boolean {
                            viewTreeObserver.removeOnPreDrawListener(this)
                            (layoutParams as CoordinatorLayout.LayoutParams).behavior = null
                            return true
                        }
                    })
                }

                setPadding(0, 0, 0, 0)
                if (backgroundRes != -1) setBackgroundResource(backgroundRes)
                findViewById<TextView>(R.id.snackbar_text).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.snackbar_action).visibility = View.INVISIBLE
                LayoutInflater.from(context).inflate(layoutRes, this)
            })
        }

        enum class Duration {
            INDEFINITE, SHORT, LONG
        }
    }
}
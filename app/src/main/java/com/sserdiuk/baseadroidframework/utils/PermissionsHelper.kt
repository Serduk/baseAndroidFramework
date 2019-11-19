package com.sserdiuk.baseadroidframework.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import com.sserdiuk.baseadroidframework.utils.RequestCode.PERMISSIONS_ACCESS_LOCATION
import com.sserdiuk.baseadroidframework.utils.RequestCode.PERMISSIONS_CAMERA
import com.sserdiuk.baseadroidframework.utils.RequestCode.PERMISSIONS_RECEIVE_SMS

private typealias OnPermissionListener = (granted: Boolean) -> Unit

class PermissionsHelper(val activity: Activity, private val contextUtil: ContextUtil) {
    val hasLocationPermission get() = contextUtil.hasLocationPermission
    val hasSmsPermission get() = contextUtil.hasSmsPermission
    val hasCameraPermission get() = contextUtil.hasCameraPermission

    private var locationPermissionListener: OnPermissionListener? = null
    private var smsPermissionListener: OnPermissionListener? = null
    private var cameraPermissionListener: OnPermissionListener? = null

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSIONS_ACCESS_LOCATION -> handle(
                permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION, locationPermissionListener
            )
            PERMISSIONS_RECEIVE_SMS -> handle(
                permissions, grantResults,
                Manifest.permission.RECEIVE_SMS, smsPermissionListener
            )
            PERMISSIONS_CAMERA -> handle(
                permissions,
                grantResults,
                Manifest.permission.CAMERA,
                cameraPermissionListener
            )
        }
    }

    private fun handle(
        permissions: Array<out String>,
        grantResults: IntArray,
        permission: String,
        listener: OnPermissionListener?
    ) {
        permissions.forEachIndexed { i, p ->
            if (p == permission) {
                listener?.invoke(grantResults[i] == PackageManager.PERMISSION_GRANTED)
            }
        }
    }
}
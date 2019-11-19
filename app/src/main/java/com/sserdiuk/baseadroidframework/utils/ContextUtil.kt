package com.sserdiuk.baseadroidframework.utils

import android.Manifest
import android.content.Context
import androidx.core.content.PermissionChecker

class ContextUtil(private val context: Context) {
    val hasLocationPermission: Boolean
        get() = PermissionChecker.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PermissionChecker.PERMISSION_GRANTED

    val hasSmsPermission: Boolean
        get() = PermissionChecker.checkSelfPermission(
            context,
            Manifest.permission.RECEIVE_SMS
        ) == PermissionChecker.PERMISSION_GRANTED

    val hasCameraPermission: Boolean
        get() = PermissionChecker.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PermissionChecker.PERMISSION_GRANTED
}
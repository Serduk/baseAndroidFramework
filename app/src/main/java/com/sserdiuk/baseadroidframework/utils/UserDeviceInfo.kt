package com.sserdiuk.baseadroidframework.utils

/**
 * Return detailed data about user device
 * Mostly should be used in "send email" or some additional statistic
 * */
class UserDeviceInfo {
    companion object {
        @Throws(FrameworkException::class)
        fun deviceInfo(): String = throw FrameworkException("Not implemented yet")
//        val deviceInfo: String = App.get().getResources().getString(R.string.build_brand) +
//                ": " +
//                Build.BRAND +
//                "\n" +
//                App.get().getResources().getString(R.string.build_model) +
//                ": " +
//                Build.MODEL +
//                "\n" +
//                App.get().getResources().getString(R.string.build_os_version) +
//                ": " +
//                Build.VERSION.CODENAME +
//                ", " +
//                Build.VERSION.RELEASE +
//                ", " +
//                App.get().getResources().getString(R.string.build_api) +
//                " " +
//                Build.VERSION.SDK_INT +
//                "\n" +
//                App.get().getResources().getString(R.string.app_version) +
//                ": " +
//                BuildConfig.VERSION_NAME +
//                "\n" +
//                App.get().getResources().getString(R.string.build_id) +
//                ": " +
//                Build.ID +
//                "\n" +
//                App.get().getResources().getString(R.string.build_type) +
//                ": " +
//                Build.TYPE +
//                "\n" +
//                App.get().getResources().getString(R.string.build_user) +
//                ": " +
//                Build.USER +
//                "\n" +
//                App.get().getResources().getString(R.string.build_board) +
//                ": " +
//                Build.BOARD +
//                "\n" +
//                App.get().getResources().getString(R.string.build_bootloader) +
//                ": " +
//                Build.BOOTLOADER +
//                "\n" +
//                App.get().getResources().getString(R.string.build_host) +
//                ": " +
//                Build.HOST +
//                "\n" +
//                App.get().getResources().getString(R.string.build_device) +
//                ": " +
//                Build.DEVICE +
//                "\n" +
//                App.get().getResources().getString(R.string.build_product) +
//                ": " +
//                Build.PRODUCT +
//                "\n" +
//                App.get().getResources().getString(R.string.build_hardware) +
//                ": " +
//                Build.HARDWARE +
//                "\n" +
//                App.get().getResources().getString(R.string.build_tags) +
//                ": " +
//                Build.TAGS
    }
}
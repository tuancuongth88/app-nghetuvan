package haiphat.com.bds.nghetuvan.models

import android.text.TextUtils

class ErrorModel {
    private var messages: List<String>? = null

    fun getErrorMessage(): String {
        return TextUtils.join("\n", messages)
    }
}
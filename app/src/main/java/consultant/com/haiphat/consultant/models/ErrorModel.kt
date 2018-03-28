package consultant.com.haiphat.consultant.models

import android.text.TextUtils

/**
 * Created by HUONG HA^P on 3/26/2018.
 */
class ErrorModel {
    var messages: List<String>? = null

    fun getErrorMessage(): String {
        return TextUtils.join("\n", messages)
    }
}
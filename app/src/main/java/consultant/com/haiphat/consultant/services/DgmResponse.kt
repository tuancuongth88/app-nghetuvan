package consultant.com.haiphat.consultant.services

import android.text.TextUtils
import consultant.com.haiphat.consultant.BaseApplication
import consultant.com.haiphat.consultant.R
import consultant.com.haiphat.consultant.models.ErrorModel
import okhttp3.Response
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

/**
 * Created by DEV-01 on 12/19/2017.
 */
open class DgmResponse{
    var status: Boolean? = false
    var responseContent: String? = null
    var exception: Exception? = null

    constructor(exception: Exception) {
        this.exception = exception
    }

    constructor(response: Response?) {
        response?.let {
            this.status = response.isSuccessful
        }
        try {
            this.responseContent = response?.body()?.string().toString()
        } catch (ex: Exception) {
            this.exception = ex
        }

    }

    fun isSuccess(): Boolean? {
        return status
    }

    fun getErrorMessage(): String? {
//        if (!isSuccess()) {
//            return null
//        }
//        if (TextUtils.isEmpty(responseContent)) {
//            return if (statusCode == 0) {
//                if (exception is TimeoutException || exception is SocketTimeoutException) {
//                    BaseApplication.context.getString(R.string.text_cannot_connect_to_server)
//                } else {
//                    BaseApplication.context.getString(R.string.text_no_internet_connection)
//                }
//            } else {
//                null
//            }
//        }
        val errorModel = GsonUtil.fromJson(responseContent, ErrorModel::class.java)
        return errorModel?.let { it.getErrorMessage() } ?: BaseApplication.context.getString(R.string.text_error)
    }

    fun hasNetwordError(): Boolean {
        return this.exception != null
    }
}


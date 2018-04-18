package haiphat.com.bds.nghetuvan.services

import android.text.TextUtils
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.models.ErrorModel
import okhttp3.Response
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

/**
 * Created by DEV-01 on 12/19/2017.
 */
open class DgmResponse {
    var status: Boolean? = false
    var statusCode: Int? = 0
    var responseContent: String? = null
    var exception: Exception? = null
    var messages : String? = null
    constructor(exception: Exception) {
        this.exception = exception
    }

    constructor(response: Response?) {
        response?.let {
            try {
                this.responseContent = response?.body()?.string().toString()
                val baseResponse = GsonUtil.fromJson(responseContent, BaseResponse::class.java)
                this.status = baseResponse?.status
                this.messages = baseResponse?.message
            } catch (ex: Exception) {
                this.exception = ex
            }
        }
    }

    fun getErrorMessage(): String? {
        if (TextUtils.isEmpty(responseContent)) {
            return if (statusCode == 0) {
                if (exception is TimeoutException || exception is SocketTimeoutException) {
                    BaseApplication.context.getString(R.string.text_cannot_connect_to_server)
                } else {
                    BaseApplication.context.getString(R.string.text_no_internet_connection)
                }
            } else {
                null
            }
        }
        return messages?.let { it } ?: BaseApplication.context.getString(R.string.text_error)
    }
}


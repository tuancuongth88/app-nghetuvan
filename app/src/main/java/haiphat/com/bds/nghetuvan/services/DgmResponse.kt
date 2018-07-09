package haiphat.com.bds.nghetuvan.services

import android.text.TextUtils
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.BaseResponse
import okhttp3.Response
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

open class DgmResponse {
    var status: Boolean? = false
    private var statusCode: Int? = 0
    var responseContent: String? = null
    private var exception: Exception? = null
    private var messages: String? = null

    constructor(exception: Exception) {
        this.exception = exception
    }

    constructor(response: Response?) {
        response?.let {
            try {
                this.responseContent = response.body()?.string().toString()
                val baseResponse = GsonUtil.fromJson(responseContent, BaseResponse::class.java)
                this.status = baseResponse?.status
                this.messages = baseResponse?.message
            } catch (ex: Exception) {
                this.exception = ex
            }
        }
    }

    fun getErrorMessage(): String? {
        if (TextUtils.isEmpty(responseContent) && statusCode == 0) {
            if (exception is TimeoutException || exception is SocketTimeoutException) {
                return BaseApplication.context.getString(R.string.text_cannot_connect_to_server)
            } else {
                return BaseApplication.context.getString(R.string.text_no_internet_connection)
            }
        }
        return messages?.let { it } ?: BaseApplication.context.getString(R.string.text_error)

    }
}


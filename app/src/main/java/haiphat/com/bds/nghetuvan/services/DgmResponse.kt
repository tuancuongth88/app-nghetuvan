package haiphat.com.bds.nghetuvan.services

import android.text.TextUtils
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.ErrorModel
import okhttp3.Response
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

open class DgmResponse {
    var status: Int? = 0
    var responseContent: String? = null
    private var exception: Exception? = null
    var message : String? = null

    constructor(exception: Exception) {
        this.exception = exception
    }

    constructor(response: Response?) {
        response?.let {
            this.status = response.code()
        }
        try {
            this.responseContent = response?.body()?.string().toString()
            val response = GsonUtil.fromJson(responseContent, ErrorModel::class.java)
            this.message = response?.message

        } catch (ex: Exception) {
            this.exception = ex
        }
    }

    fun isSuccess(): Boolean {
        return status in 200..299
    }

    fun getErrorMessage(): String? {
        if (status == 401) {
            return message?.let { it } ?: BaseApplication.context.getString(R.string.text_error)
        }
        if (TextUtils.isEmpty(responseContent) && status == 0) {
            if (exception is TimeoutException || exception is SocketTimeoutException) {
                return BaseApplication.context.getString(R.string.text_cannot_connect_to_server)
            } else {
                return BaseApplication.context.getString(R.string.text_no_internet_connection)
            }
        }
        return message?.let { it } ?: BaseApplication.context.getString(R.string.text_error)

    }

    fun hasNetwordError(): Boolean {
        return this.exception != null
    }
}


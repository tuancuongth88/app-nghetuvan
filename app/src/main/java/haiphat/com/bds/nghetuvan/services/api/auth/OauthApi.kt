package haiphat.com.bds.nghetuvan.services.api.auth

import haiphat.com.bds.nghetuvan.models.auth.LoginResponse
import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*

class OauthApi : BaseApi() {

    override fun apiUrl(): String? {
        return "oauth/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL_OAUTH
    }

    fun login(username: String?, password: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("username", username ?: "")
        data.put("password", password ?: "")
        data.put("grant_type", "password")
        data.put("client_id", Config.CLIENT_ID)
        data.put("client_secret", Config.CLIENT_SECRET)
        this.upload("token", data, onResponse)
    }

    fun refreshTokenSynchronous(refreshToken : String?) : DgmResponse?  {
        val data = HashMap<String, String>()
        data.put("refresh_token", refreshToken ?: "")
        data.put("grant_type", "refresh_token")
        data.put("client_id", Config.CLIENT_ID)
        data.put("client_secret", Config.CLIENT_SECRET)
        val dgmResponse = this.postUrlEncoded("/token", data)
        if (dgmResponse?.isSuccess()!!) {
            UserServices.saveUserInfo(GsonUtil.fromJson(dgmResponse?.responseContent, LoginResponse::class.java))
        }
        return dgmResponse
    }

}
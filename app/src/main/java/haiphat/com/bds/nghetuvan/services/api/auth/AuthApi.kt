package haiphat.com.bds.nghetuvan.services.api.auth

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.*

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class AuthApi : BaseApi() {
    override fun apiUrl(): String? {
        return "user/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun login(email: String?, password: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        data.put("password", password ?: "")
        this.upload("login", data, onResponse)
    }

    fun register(email: String?, fullName: String?, password: String?, confirmPassword: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        data.put("fullname", fullName ?: "")
        data.put("password", password ?: "")
        data.put("password_confirmation", confirmPassword ?: "")
        this.upload("signup", data, onResponse)
    }

    fun forgotPassword(email: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        this.upload("forgotPassword", data, onResponse)
    }
}
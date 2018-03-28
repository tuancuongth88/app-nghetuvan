package consultant.com.haiphat.consultant.services.api.auth

import consultant.com.haiphat.consultant.services.Config
import consultant.com.haiphat.consultant.services.DgmResponse
import consultant.com.haiphat.consultant.services.api.BaseApi
import java.util.*

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class AuthApi : BaseApi() {
    override fun apiUrl(): String? {
        return "api/administrator"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun login(email: String?, password: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        data.put("password", password ?: "")
        this.postUrlEncoded("/login", data, onResponse)
    }

    fun register(email: String?, name: String?, phone: String?, password: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        data.put("name", name ?: "")
        data.put("phone", phone ?: "")
        data.put("password", password ?: "")
        this.postUrlEncoded("/token", data, onResponse)
    }
}
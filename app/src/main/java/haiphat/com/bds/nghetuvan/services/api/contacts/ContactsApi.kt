package haiphat.com.bds.nghetuvan.services.api.contacts

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.HashMap

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ContactsApi : BaseApi() {
    override fun apiUrl(): String? {
        return "contact/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun sendContact(name: String?, email: String?, phone: String?, description:String?, address: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("name", name ?: "")
        data.put("email", email ?: "")
        data.put("phone", phone ?: "")
        data.put("description", description ?: "")
        data.put("address", address ?: "")
        this.upload("upload-information", data, onResponse)
    }
}
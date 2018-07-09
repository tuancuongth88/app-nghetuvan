package haiphat.com.bds.nghetuvan.services.api.auth

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*

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

    fun register(email: String?, fullName: String?, password: String?, confirmPassword: String?, phone: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        data.put("fullname", fullName ?: "")
        data.put("password", password ?: "")
        data.put("password_confirmation", confirmPassword ?: "")
        data.put("phone", phone ?: "")
        this.upload("signup", data, onResponse)
    }

    fun forgotPassword(email: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        this.upload("forgotPassword", data, onResponse)
    }

    fun updateProfile(userId : String?, fullName: String?, phone: String?, birthDay: String?, idNumber: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("fullname", fullName ?: "")
        data.put("phone", phone ?: "")
        data.put("birthday", birthDay ?: "")
        data.put("identity", idNumber ?: "")
        this.upload("update-info-user/" + userId, data, onResponse)
    }

    fun getProfile(id: String?, onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        val queryString = this.parseUrlQueryStringWithParams("getprofile/" +id, params)
//        this.get(queryString, onResponse)
        this[queryString, onResponse]
    }

    fun changePassword(userId: String?, oldPassword: String?, newPassword: String?, newConfirmPassword: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("old_password", oldPassword ?: "")
        data.put("new_password", newPassword ?: "")
        data.put("new_password_confirmation", newConfirmPassword ?: "")
        this.upload("change-password/" + userId, data, onResponse)
    }

    fun changeAvatar(userId: String?, path: String?, onResponse: (DgmResponse) -> Unit) {
        val builder = MultipartBody.Builder()
        builder.setType(MultipartBody.FORM)
        val fileUpload = File(path)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), fileUpload)
        builder.addFormDataPart("avatar", fileUpload.name, fileRequestBody)
        this.upload("change-avatar/" + userId, builder, onResponse)
    }

    fun activeAccount(codeActive:String?, onResponse: (DgmResponse) -> Unit){
        this.upload("active-account/" + codeActive, HashMap<String, String>(), onResponse)
    }
}
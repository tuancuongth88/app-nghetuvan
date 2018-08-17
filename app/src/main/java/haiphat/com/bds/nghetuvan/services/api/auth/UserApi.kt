package haiphat.com.bds.nghetuvan.services.api.auth

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*

class UserApi : BaseApi() {

    override fun apiUrl(): String? {
        return "user/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
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

    fun updateProfile(userId : String?, fullName: String?, phone: String?, birthDay: String?, identity: String?, address : String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("fullname", fullName ?: "")
        data.put("phone", phone ?: "")
        data.put("birthday", birthDay ?: "")
        data.put("address", address ?: "")
        data.put("identity", identity ?: "")
        this.upload("edit/" + userId, data, onResponse)
    }

    fun getProfile(onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        val queryString = this.parseUrlQueryStringWithParams("user-profile", params)
        this[queryString, onResponse]
    }

    fun changePassword(email: String?,oldPassword: String?, newPassword: String?, newConfirmPassword: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email?: "")
        data.put("current_password", oldPassword ?: "")
        data.put("password", newPassword ?: "")
        data.put("password_confirmation", newConfirmPassword ?: "")
        this.upload("change-password", data, onResponse)
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
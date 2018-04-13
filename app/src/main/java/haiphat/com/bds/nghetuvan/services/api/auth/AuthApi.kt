package haiphat.com.bds.nghetuvan.services.api.auth

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
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

    fun updateProfile(fullName: String?, phone: String?, birthDay: String?, idNumber: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", fullName ?: "")
        data.put("phone", phone ?: "")
        data.put("birthday", birthDay ?: "")
        data.put("idnumber", idNumber ?: "")
        this.upload("upload-information", data, onResponse)
    }

    fun changePassword(oldPassword: String?, newPassword: String?, confirmPassword: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("oldPassword", oldPassword ?: "")
        data.put("newPassword", newPassword ?: "")
        data.put("confirmPassword", confirmPassword ?: "")
        this.upload("upload-information", data, onResponse)
    }

    fun changeAvatar(path: String?, onResponse: (DgmResponse) -> Unit) {
        val builder = MultipartBody.Builder()
        builder.setType(MultipartBody.FORM)
        val fileUpload = File(path)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), fileUpload)
        builder.addFormDataPart("file", fileUpload.getName(), fileRequestBody)
        this.upload("/profileImage", builder, onResponse)
    }

    fun sendContact(email: String?, phone: String?, content:String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("email", email ?: "")
        this.upload("upload-information", data, onResponse)
    }
}
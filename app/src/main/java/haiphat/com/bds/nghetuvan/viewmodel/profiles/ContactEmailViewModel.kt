package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.databinding.BaseObservable
import haiphat.com.bds.nghetuvan.models.auth.ProfileResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.contacts.ContactsApi

class ContactEmailViewModel : BaseObservable() {
    var email: String? = null
    var phone: String? = null
    var content: String? = null
    var address: String? = null
    var name: String? = null

    fun sendContact(onSuccess: (String?) -> Unit, onFailed: (String?) -> Unit) {
        ContactsApi().sendContact(name, email, phone, content, address, onResponse = {
            val profileResponse = GsonUtil.fromJson(it.responseContent, ProfileResponse::class.java)
            if (it.status == 200) {
                onSuccess(profileResponse?.message)
            } else {
                onFailed(it.getErrorMessage())
            }
        })
    }

    fun setData() {
        this.name = UserServices.userInfo?.fullname
        this.phone = UserServices.userInfo?.phone
        this.email = UserServices.userInfo?.email
        this.notifyChange()
    }
}
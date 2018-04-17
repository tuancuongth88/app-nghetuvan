package haiphat.com.bds.nghetuvan.viewmodel.profiles

import haiphat.com.bds.nghetuvan.models.auth.ProfileResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.contacts.ContactsApi

/**
 * Created by HUONG HA^P on 4/13/2018.
 */
class ContactEmailViewModel() {
    var email: String? = null
    var phone: String? = null
    var content: String? = null
    var address : String? = null
    var name : String? = null

    fun sendContact(onSuccess: () -> Unit, onFailed: (String?) -> Unit) {
        ContactsApi().sendContact(name, email, phone, content, address, onResponse = {
            var profileResponse = GsonUtil.fromJson(it.responseContent, ProfileResponse::class.java)
//            it.status
            onSuccess()
        })
    }

}
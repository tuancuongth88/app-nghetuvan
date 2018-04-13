package haiphat.com.bds.nghetuvan.viewmodel.profiles

import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

/**
 * Created by HUONG HA^P on 4/13/2018.
 */
class ContactEmailViewModel() {
    var email: String? = null
    var phone: String? = null
    var content: String? = null

    fun sendContact(onSuccess: () -> Unit, onFailed: (String?) -> Unit) {
        AuthApi().sendContact(email, phone, content, onResponse = {
            onSuccess()
        })
    }

}
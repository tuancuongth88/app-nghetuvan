package consultant.com.haiphat.consultant.viewmodel.auth

import consultant.com.haiphat.consultant.models.auth.LoginResponse
import consultant.com.haiphat.consultant.services.GsonUtil
import consultant.com.haiphat.consultant.services.api.auth.AuthApi

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class RegisterViewModel {
    var password : String? = null
    var email : String? = null
    var fullName : String? = null
    var phone : String? = null
    var confirmPassword :String? = null

    fun register(onSuccess : () ->Unit, onFailed : (String?) -> Unit){
        AuthApi().register(email, fullName, phone, password, onResponse = {
            onSuccess()
        })
    }
}
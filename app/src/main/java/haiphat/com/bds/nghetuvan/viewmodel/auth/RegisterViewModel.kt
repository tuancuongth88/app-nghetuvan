package haiphat.com.bds.nghetuvan.viewmodel.auth

import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

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
        AuthApi().register(email, fullName, password, confirmPassword, onResponse = {
            if (it?.isSuccess()?: false){
                onSuccess()
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }
}
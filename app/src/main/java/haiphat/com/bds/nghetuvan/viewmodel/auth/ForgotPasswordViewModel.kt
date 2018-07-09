package haiphat.com.bds.nghetuvan.viewmodel.auth

import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

class ForgotPasswordViewModel {
    var email : String? = null

    fun forgotPassword(onSuccess : (String) ->Unit, onFailed : (String?) -> Unit){
        AuthApi().forgotPassword(email, onResponse = {
            onSuccess(BaseApplication.context.getString(R.string.text_forgot_passwrord_successfull))
        })
    }
}
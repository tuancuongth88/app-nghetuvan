package haiphat.com.bds.nghetuvan.viewmodel.auth

import haiphat.com.bds.nghetuvan.models.auth.LoginResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class LoginViewModel {
    var password : String? = null
    var email : String? = null

    fun loginEmail(onSuccess : () ->Unit, onFailed : (String?) -> Unit){
        AuthApi().login(email, password, onResponse = {
            val loginResponse = GsonUtil.fromJson(it?.responseContent, LoginResponse::class.java)
            if (it?.isSuccess()?: false){
                print("success: " + GsonUtil.toJson(it))
               onSuccess()
            }else{
                loginResponse?.let { onFailed(it.message) } ?: onFailed(it.getErrorMessage())
            }
        })
    }
}
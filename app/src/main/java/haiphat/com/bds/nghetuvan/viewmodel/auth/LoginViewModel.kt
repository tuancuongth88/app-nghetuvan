package haiphat.com.bds.nghetuvan.viewmodel.auth

import haiphat.com.bds.nghetuvan.models.auth.AuthResponse
import haiphat.com.bds.nghetuvan.models.auth.LoginResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class LoginViewModel {
    var password : String? = null
    var email : String? = null

    fun loginEmail(onSuccess : () ->Unit, onFailed : (String?) -> Unit){
        AuthApi().login(email, password, onResponse = {
            val authResponse = GsonUtil.fromJson(it?.responseContent, AuthResponse::class.java)
            it?.isSuccess()?.let {
                UserServices.saveUserInfo(authResponse?.data)
                onSuccess()
            } ?: authResponse?.let { onFailed(it.message) } ?: onFailed(it.getErrorMessage())

//            if (it?.isSuccess()?: false){
//                UserServices.saveUserInfo(authResponse?.data)
//               onSuccess()
//            }else{
//                authResponse?.let { onFailed(it.message) } ?: onFailed(it.getErrorMessage())
//            }
        })
    }
}
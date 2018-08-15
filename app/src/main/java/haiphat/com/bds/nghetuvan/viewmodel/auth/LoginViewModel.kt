package haiphat.com.bds.nghetuvan.viewmodel.auth

import haiphat.com.bds.nghetuvan.models.auth.LoginResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.OauthApi

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class LoginViewModel {
    var password : String? = null
    var username : String? = null

    fun loginEmail(onSuccess : () ->Unit, onFailed : (String?) -> Unit){
        OauthApi().login(username, password, onResponse = {
            val authResponse = GsonUtil.fromJson(it.responseContent, LoginResponse::class.java)
            if (it.isSuccess()){
                    UserServices.saveUserInfo(authResponse)
                    onSuccess()
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }
}
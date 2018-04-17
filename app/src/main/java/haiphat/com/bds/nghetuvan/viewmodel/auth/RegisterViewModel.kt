package haiphat.com.bds.nghetuvan.viewmodel.auth

import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
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

    fun register(onSuccess : (String) ->Unit, onFailed : (String?) -> Unit){
        AuthApi().register(email, fullName, password, confirmPassword, phone,onResponse = {
            val registerResponse = GsonUtil.fromJson(it.responseContent, BaseResponse::class.java)
            it?.status?.let {
                registerResponse?.message?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        })
    }
}
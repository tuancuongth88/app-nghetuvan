package haiphat.com.bds.nghetuvan.viewmodel.profiles

import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.UserApi

class ChangePasswordViewModel {

    var oldPassword: String? = null
    var newPassword: String? = null
    var confirmPassword: String? = null

    fun changePassword(onSuccess: (String?) -> Unit, onFailed: (String?) -> Unit) {
        UserApi().changePassword(oldPassword, newPassword, confirmPassword, onResponse = {
            val dataResponse = GsonUtil.fromJson(it.responseContent, BaseResponse::class.java)
            if (it.isSuccess()){
                onSuccess(dataResponse?.message)
            }else{
                onFailed(it.getErrorMessage())
            }

//            if (dataResponse?.status == true) {
//                onSuccess()
//            } else {
//                onFailed(it.getErrorMessage())
//            }
        })
    }

}
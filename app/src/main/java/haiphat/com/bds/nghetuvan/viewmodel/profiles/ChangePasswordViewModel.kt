package haiphat.com.bds.nghetuvan.viewmodel.profiles

import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.UserApi

class ChangePasswordViewModel {

    var oldPassword: String? = null
    var newPassword: String? = null
    var confirmPassword: String? = null

    fun changePassword(onSuccess: (String?) -> Unit, onFailed: (String?) -> Unit) {
        UserApi().changePassword(UserServices?.userInfo?.email, oldPassword, newPassword, confirmPassword, onResponse = {
            if (it.isSuccess()){
                onSuccess(it.message)
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }

}
package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.databinding.BaseObservable
import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

/**
 * Created by HUONG HA^P on 4/13/2018.
 */
class ChangePasswordViewModel {

    var oldPassword: String? = null
    var newPassword: String? = null
    var confirmPassword: String? = null

    fun changePassword(onSuccess: () -> Unit, onFailed: (String?) -> Unit) {
        AuthApi().changePassword(UserServices.userInfo?.id, oldPassword, newPassword, confirmPassword, onResponse = {
            var dataResponse = GsonUtil.fromJson(it.responseContent, BaseResponse::class.java)
            if (dataResponse?.status == true) {
                onSuccess()
            } else {
                onFailed(it.getErrorMessage())
            }
        })
    }

}
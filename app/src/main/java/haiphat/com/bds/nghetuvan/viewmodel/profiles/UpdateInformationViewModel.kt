package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.databinding.BaseObservable
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.auth.AuthResponse
import haiphat.com.bds.nghetuvan.models.auth.UpdateInformationResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.AuthApi

/**
 * Created by HUONG HA^P on 4/13/2018.
 */
class UpdateInformationViewModel : BaseObservable(){

    var fullName: String? = null
    var birthDay: String? = null
    var phone: String? = null
    var idNumber: String? = null

    fun updateInformation(onSuccess: () -> Unit, onFailed: (String?) -> Unit) {
        AuthApi().updateProfile(UserServices?.userInfo?.id, fullName, phone, birthDay, idNumber, onResponse = {
            val updateInformationResponse = GsonUtil.fromJson(it?.responseContent, UpdateInformationResponse::class.java)
            it?.isSuccess()?.let {
                updateInformationResponse?.data?.let {
                    UserServices.saveProfile(updateInformationResponse?.data)
                    onSuccess()
                }?: onFailed(BaseApplication.context.getString(R.string.text_error))
            } ?: updateInformationResponse?.let { onFailed(it.message) } ?: onFailed(it.getErrorMessage())

        })
    }

    fun setData() {
        this.fullName = UserServices.userInfo?.fullname
        this.phone = UserServices.userInfo?.phone
        this.birthDay = UserServices.userInfo?.birthday
        this.idNumber = UserServices.userInfo?.identity
        this.notifyChange()
    }
}
package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.databinding.BaseObservable
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
        AuthApi().updateProfile(fullName, phone, birthDay, idNumber, onResponse = {
            onSuccess()
        })
    }

    fun setData() {
        this.fullName = UserServices.userInfo?.fullname
        this.phone = UserServices.userInfo?.phone
        this.birthDay = UserServices.userInfo?.birthday
        this.idNumber = UserServices.userInfo?.idNumber
        this.notifyChange()
    }
}
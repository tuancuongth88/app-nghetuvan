package haiphat.com.bds.nghetuvan.viewmodel

import haiphat.com.bds.nghetuvan.models.auth.ProfileResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.UserApi

/**
 * Created by HUONG HA^P on 4/17/2018.
 */
class SplashViewModel {

    fun activeAccount(codeActive: String?, onSuccess: () -> Unit, onFailed: (String?) -> Unit) {
        UserApi().activeAccount(codeActive, onResponse = {
            var profileResponse = GsonUtil.fromJson(it.responseContent, ProfileResponse::class.java)
            profileResponse?.data?.let {
                UserServices.saveProfile(it)
                onSuccess()
            } ?: onFailed(it.getErrorMessage())
        })

    }
}
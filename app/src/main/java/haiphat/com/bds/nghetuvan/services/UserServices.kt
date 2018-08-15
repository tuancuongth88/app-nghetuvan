package haiphat.com.bds.nghetuvan.services

import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.constants.SharePreferencesKeys
import haiphat.com.bds.nghetuvan.models.auth.LoginResponse
import haiphat.com.bds.nghetuvan.models.auth.UserResponse
import haiphat.com.bds.nghetuvan.utils.SharePreferencesLoaders

object UserServices {

    var accessToken: String? = null
    var userInfo: UserResponse? = null
    var refreshToken: String? = null

    init {
        this.accessToken = SharePreferencesLoaders.getValue(SharePreferencesKeys.ACCESS_TOKEN, null)
        this.refreshToken = SharePreferencesLoaders.getValue(SharePreferencesKeys.REFRESH_TOKEN, null)
        var strJson = SharePreferencesLoaders.getValue(SharePreferencesKeys.USER_INFO, null)
        strJson?.let {
            userInfo = GsonUtil.fromJson(strJson, UserResponse::class.java)
        }
    }

    fun saveUserInfo(loginResponse: LoginResponse?) {
        this.accessToken = loginResponse?.access_token
        this.refreshToken = loginResponse?.refresh_token
        SharePreferencesLoaders.saveValue(SharePreferencesKeys.ACCESS_TOKEN, this.accessToken)
        SharePreferencesLoaders.saveValue(SharePreferencesKeys.REFRESH_TOKEN, this.refreshToken)
    }

    fun saveProfile(userResponse: UserResponse?){
        this.userInfo = userResponse
        SharePreferencesLoaders.saveValue(SharePreferencesKeys.USER_INFO, userInfo?.let { GsonUtil.toJson(it) })
    }

    fun logout() {
        this.userInfo = null
        this.accessToken = null
        SharePreferencesLoaders.clear()
        val pIntent = Intent()
        pIntent.action = IntentActionKeys.FORCE_LOGOUT_ACTION
        LocalBroadcastManager.getInstance(BaseApplication.context).sendBroadcast(pIntent)
    }
}
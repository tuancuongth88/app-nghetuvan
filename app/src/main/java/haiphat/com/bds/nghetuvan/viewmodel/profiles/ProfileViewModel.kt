package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.content.Context
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.auth.ProfileResponse
import haiphat.com.bds.nghetuvan.models.auth.UploadAvatarResponse
import haiphat.com.bds.nghetuvan.models.auth.UserResponse
import haiphat.com.bds.nghetuvan.models.profiles.ProfileModel
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.services.api.auth.UserApi

class ProfileViewModel{

    fun updateAvatar(path : String? , onSuccess : (String?) ->Unit, onFailed : (String?) -> Unit) {
        UserApi().changeAvatar(UserServices.userInfo?.id, path, onResponse = {
            val response = GsonUtil.fromJson(it.responseContent, UploadAvatarResponse::class.java)
            if(it.isSuccess()){
                onSuccess(response?.data?.message)
            }else{
                onFailed(it.getErrorMessage())
            }

        })
    }

    fun getProfile(onSuccess: (UserResponse?) -> Unit, onFailed: (String?) -> Unit) {
        UserApi().getProfile(onResponse = {
            val profileResponse = GsonUtil.fromJson(it.responseContent, ProfileResponse::class.java)
            if (it.isSuccess()){
                UserServices.saveProfile(profileResponse?.data)
                onSuccess(profileResponse?.data)
            }else{ onFailed(it.getErrorMessage())}
        })
    }

    fun listProfile(context: Context): ArrayList<ProfileModel> {
        var arrayList = ArrayList<ProfileModel>()
        arrayList.add(ProfileModel(R.drawable.ic_profile_info_account, context.getString(R.string.profile_info_account), R.drawable.ic_next))
        arrayList.add(ProfileModel(R.drawable.ic_profile_email, context.getString(R.string.title_action_bar_contact), R.drawable.ic_next))
        arrayList.add(ProfileModel(R.drawable.ic_profile_change_pass, context.getString(R.string.profile_change_password), R.drawable.ic_next))
        arrayList.add(ProfileModel(R.drawable.ic_profile_consultation_calendar, context.getString(R.string.profile_history_transactions), R.drawable.ic_next))
//        arrayList.add(ProfileModel(R.drawable.ic_profile_info_sms, context.getString(R.string.profile_message), R.drawable.ic_next))
        arrayList.add(ProfileModel(R.drawable.ic_profile_log_out, context.getString(R.string.log_out)))
        return arrayList
    }
}
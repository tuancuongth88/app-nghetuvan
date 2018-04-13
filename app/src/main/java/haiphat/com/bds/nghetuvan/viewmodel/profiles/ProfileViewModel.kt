package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.content.Context
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.profiles.ProfileModel

/**
 * Created by HUONG HA^P on 4/12/2018.
 */
class ProfileViewModel{

//    fun updateAvatar(path : String? , onSuccess : () ->Unit, onFailed : (String?) -> Unit) {
//        UserApi().updateAvatar(path, onResponse = {
//            if (it.isSuccess()){
//                onSuccess()
//            }else{
//                onFailed(it.getErrorMessage())
//            }
//        })
//    }
//
//    fun getProfile(onSuccess: (UserResponse) -> Unit, onFailed: (String?) -> Unit) {
//        UserApi().getProfile( onResponse = {
//            val userResponse = GsonUtil.fromJson(it.responseContent, UserResponse::class.java)
//            if (it.isSuccess()) {
//                userResponse?.let {
//                    UserServices.saveProfile(userResponse)
//                    onSuccess(it)
//                }
//            } else {
//                onFailed(it.getErrorMessage())
//            }
//        })
//    }

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
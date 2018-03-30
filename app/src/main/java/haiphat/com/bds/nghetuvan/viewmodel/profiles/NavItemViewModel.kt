package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.content.Context
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.profiles.ProfileModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NavItemViewModel {
    fun listNavItemProfile(context: Context): ArrayList<ProfileModel> {
        var arrayList = ArrayList<ProfileModel>()
        arrayList.add(ProfileModel(R.drawable.ic_nav_main_page, context.getString(R.string.title_action_bar_home)))
        arrayList.add(ProfileModel(R.drawable.ic_nav_course, context.getString(R.string.title_action_bar_partner)))
        arrayList.add(ProfileModel(R.drawable.ic_nav_info, context.getString(R.string.title_action_bar_news)))
        arrayList.add(ProfileModel(R.drawable.ic_nav_contact, context.getString(R.string.title_action_bar_contact)))
        arrayList.add(ProfileModel(R.drawable.ic_profile_log_out, context.getString(R.string.log_out)))
        return arrayList
    }
}
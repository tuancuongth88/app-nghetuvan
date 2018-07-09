package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.content.Context
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.profiles.ProfileModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NavItemViewModel {
    fun listNavItemProfile(context: Context): ArrayList<ProfileModel> {
        val arrayList = ArrayList<ProfileModel>()
        arrayList.add(ProfileModel(R.drawable.ic_home, context.getString(R.string.title_action_bar_home)))
        arrayList.add(ProfileModel(R.drawable.ic_du_an, context.getString(R.string.title_action_bar_duan)))
        arrayList.add(ProfileModel(R.drawable.ic_gio_hang, context.getString(R.string.title_action_bar_bh_online)))
        arrayList.add(ProfileModel(R.drawable.ic_dao_tao, context.getString(R.string.title_action_bar_daotao)))
        arrayList.add(ProfileModel(R.drawable.ic_doi_tac, context.getString(R.string.title_action_bar_partner)))
        arrayList.add(ProfileModel(R.drawable.ic_tin_tuc, context.getString(R.string.title_action_bar_news)))
        arrayList.add(ProfileModel(R.drawable.ic_lien_he, context.getString(R.string.title_action_bar_contact)))
        arrayList.add(ProfileModel(R.drawable.ic_logout, context.getString(R.string.log_out)))
        return arrayList
    }
}
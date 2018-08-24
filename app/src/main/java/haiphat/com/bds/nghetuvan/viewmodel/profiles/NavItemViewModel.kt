package haiphat.com.bds.nghetuvan.viewmodel.profiles

import android.content.Context
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.profiles.ProfileModel
import haiphat.com.bds.nghetuvan.services.UserServices

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NavItemViewModel {
    fun listNavItemProfile(context: Context): ArrayList<ProfileModel> {
        val arrayList = ArrayList<ProfileModel>()
        arrayList.add(ProfileModel(R.drawable.ic_profile, context.getString(R.string.txt_nav_profile)))
        arrayList.add(ProfileModel(R.drawable.ic_transaction_history, context.getString(R.string.txt_nav_transaction_history)))
        arrayList.add(ProfileModel(R.drawable.ic_customer_management, context.getString(R.string.txt_nav_customer_management)))
        return arrayList

    }

    fun listSystemUnitily(context: Context) : ArrayList<ProfileModel>{
        val list = ArrayList<ProfileModel>()
        list.add(ProfileModel(R.drawable.ic_nav_warehouse_real_estate, context.getString(R.string.txt_nav_warehouse_real_estate)))
        list.add(ProfileModel(R.drawable.ic_table_of_goods, context.getString(R.string.txt_nav_table_of_goods)))
        list.add(ProfileModel(R.drawable.ic_educational_training, context.getString(R.string.txt_nav_education_training)))
        list.add(ProfileModel(R.drawable.ic_nav_warehouse_real_estate, context.getString(R.string.txt_nav_news)))
        list.add(ProfileModel(R.drawable.ic_table_of_goods, context.getString(R.string.txt_nav_partner)))
        list.add(ProfileModel(R.drawable.ic_prerogative, context.getString(R.string.txt_nav_prerogative)))
        if (UserServices.userInfo == null){
            list.add(ProfileModel(R.drawable.ic_log_out, context.getString(R.string.log_in)))
        }else {
            list.add(ProfileModel(R.drawable.ic_log_out, context.getString(R.string.log_out)))
        }
        return list
    }
}
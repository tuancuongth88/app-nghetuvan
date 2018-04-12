package haiphat.com.bds.nghetuvan.view.fragment.profile

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.ProfileAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentProfileBinding
import haiphat.com.bds.nghetuvan.models.auth.UserResponse
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.profiles.ProfileViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProfileFragment : BaseFragment(){

    private lateinit var dataBindingFragmentProfile: FragmentProfileBinding
    private var profileViewModel = ProfileViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentProfile = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        initView()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        UserServices.userInfo?.let {
            bindData(it)
        }
        return dataBindingFragmentProfile.root
    }
    
    private fun initView(){
        val recyclerView = dataBindingFragmentProfile?.rvProfile
        var adapter = context?.let { profileViewModel.listProfile(it) }?.let {
            ProfileAdapter(it, onClick = {
                when (it.name) {
//                    getString(R.string.profile_info_account) -> {
//                        startActivityForResult(Intent(activity, UpdateInformationActivity::class.java), IntentActionKeys.UPDATE_ACCOUNT_INFORMATION)
//                    }
//                    getString(R.string.profile_change_email) -> {
//                        startActivityForResult(Intent(activity, ChangeEmailActivity::class.java), IntentActionKeys.PROFILE_CHANGE_EMAIL)
//                    }
//                    getString(R.string.profile_change_password) -> {
//                        startActivity(Intent(activity, ChangePasswordActivity::class.java))
//                    }
//                    getString(R.string.profile_consultation_calendar) -> {
//                    }
//                    getString(R.string.profile_message) -> {
//
//                    }
                    getString(R.string.log_out) -> {
                        (activity as HomeActivity).showDialogLogOut()
                    }
                }
            })
        }
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter
    }
    private fun bindData(userResponse: UserResponse?) {
        dataBindingFragmentProfile?.rivAvatar?.fromUrl(userResponse?.avatar, placeHolder = R.drawable.ic_defaut_avatar)
        dataBindingFragmentProfile?.tvName?.text = userResponse?.fullname
        dataBindingFragmentProfile?.tvEmail?.text = userResponse?.email
    }
}
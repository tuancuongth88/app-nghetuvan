package haiphat.com.bds.nghetuvan.view.fragment.profile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.soundcloud.android.crop.Crop
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.ProfileAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentProfileBinding
import haiphat.com.bds.nghetuvan.models.auth.UserResponse
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.DialogChangeAvatar
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.view.profile.ChangePasswordActivity
import haiphat.com.bds.nghetuvan.view.profile.ContactEmailActivity
import haiphat.com.bds.nghetuvan.view.profile.UpdateInformationActivity
import haiphat.com.bds.nghetuvan.viewmodel.profiles.ProfileViewModel
import java.io.File

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProfileFragment : BaseFragment(){

    private lateinit var dataBindingFragmentProfile: FragmentProfileBinding
    private var profileViewModel = ProfileViewModel()
    private val REQUEST_CAMERA = 1888
    private val SELECT_FILE = 1889
    private var imageUri: Uri? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentProfile = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        initView()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        UserServices.userInfo?.let {
            bindData(it)
        }
        dataBindingFragmentProfile.rivAvatar.setOnClickListener {
            var dialogChangeImage = DialogChangeAvatar(activity, onSelectedCamera = {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA), IntentActionKeys.REQUEST_CAMERA_PERMISSION)
                }else{
                    openCamera()
                }
            }, onSelectedGallery = {
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), IntentActionKeys.REQUEST_SELECT_FILE_PERMISSION)
            })
            dialogChangeImage.setCanceledOnTouchOutside(false)
            dialogChangeImage.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogChangeImage.show()

        }
        return dataBindingFragmentProfile.root
    }
    
    private fun initView(){
        val recyclerView = dataBindingFragmentProfile.rvProfile
        var adapter = context?.let { profileViewModel.listProfile(it) }?.let {
            ProfileAdapter(it, onClick = {
                when (it.name) {
                    getString(R.string.profile_info_account) -> {
                        startActivityForResult(Intent(activity, UpdateInformationActivity::class.java), IntentActionKeys.UPDATE_ACCOUNT_INFORMATION)
                    }
                    getString(R.string.title_action_bar_contact) -> {
                        startActivity(Intent(activity, ContactEmailActivity::class.java))
                    }
                    getString(R.string.profile_change_password) -> {
                        startActivity(Intent(activity, ChangePasswordActivity::class.java))
                    }
                    getString(R.string.profile_history_transactions) -> {
                    }
                    getString(R.string.log_out) -> {
                        (activity as HomeActivity).showDialogLogOut()
                    }
                }
            })
        }
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
    private fun bindData(userResponse: UserResponse?) {
        dataBindingFragmentProfile.rivAvatar.fromUrl(userResponse?.avatar, placeHolder = R.drawable.ic_defaut_avatar)
        dataBindingFragmentProfile.tvName.text = userResponse?.fullname
        dataBindingFragmentProfile.tvEmail.text = userResponse?.email
    }

    private fun changeAvatar(pathTofFile: String) {
        ShowLoading.show(activity)
        profileViewModel.updateAvatar(pathTofFile, onSuccess = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = context,dialogTitle = getString(R.string.alert_title_inform), message = it, onClick = {
                UserServices.userInfo?.let {
                    bindData(it)
                }
            })
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }

    private fun beginCrop(source: Uri?) {
        val destination = Uri.fromFile(File(Environment.getExternalStorageDirectory(), System.currentTimeMillis().toString() + ".jpg"))
        Crop.of(source, destination).asSquare().start(activity, this@ProfileFragment)
    }

    private fun handleCrop(resultCode: Int, result: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            changeAvatar(Crop.getOutput(result).path)
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(activity, getString(R.string.text_error), Toast.LENGTH_LONG).show()
        }
    }


    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        imageUri = context?.let {
            FileProvider.getUriForFile(it, it.packageName,
                    File(Environment.getExternalStorageDirectory(), System.currentTimeMillis().toString() + ".jpg"))
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(intent, REQUEST_CAMERA)
    }

    private fun openGallery() {
        val intent =
                Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, getString(R.string.change_image_select_file)), SELECT_FILE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (CommonUtil.requestPermissionGrantResults(grantResults)){
            when(requestCode){
                IntentActionKeys.REQUEST_CAMERA_PERMISSION ->{
                    openCamera()
                }
                IntentActionKeys.REQUEST_SELECT_FILE_PERMISSION ->{
                    openGallery()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            IntentActionKeys.UPDATE_ACCOUNT_INFORMATION ->{
                if (resultCode == IntentActionKeys.KEY_RELOAD_DATA){
                    UserServices.userInfo?.let {
                        bindData(it)
                    }
                }
            }
            SELECT_FILE -> {
                if (resultCode == Activity.RESULT_OK) {
                    beginCrop(data?.data)
                }
            }
            REQUEST_CAMERA -> {
                if (resultCode == Activity.RESULT_OK) {
                    beginCrop(imageUri)
                }
            }
            Crop.REQUEST_CROP -> {
                handleCrop(resultCode, data)
            }
        }

    }
}
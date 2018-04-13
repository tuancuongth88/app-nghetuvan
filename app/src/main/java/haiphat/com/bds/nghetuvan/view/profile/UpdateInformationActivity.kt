package haiphat.com.bds.nghetuvan.view.profile

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityUpdateInformationBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.profiles.UpdateInformationViewModel

class UpdateInformationActivity : BaseActivity() {

    private lateinit var dataBindingUpdateInformation: ActivityUpdateInformationBinding
    private var updateInformationViewModel = UpdateInformationViewModel()

    override fun getContentView(): View {
        dataBindingUpdateInformation = DataBindingUtil.inflate(layoutInflater, R.layout.activity_update_information, null, false)
        dataBindingUpdateInformation.updateInformation = updateInformationViewModel
        dataBindingUpdateInformation.rippleSave.setOnRippleCompleteListener {
            updateAccountInformation()
        }
        return dataBindingUpdateInformation.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        updateInformationViewModel.setData()
    }

    private fun updateAccountInformation() {
        if (Validator().validate(dataBindingUpdateInformation)) {
            updateInformationViewModel.fullName = dataBindingUpdateInformation.tetName.text.toString()
            updateInformationViewModel.birthDay = dataBindingUpdateInformation.telBirthDay.text.toString()
            updateInformationViewModel.phone = dataBindingUpdateInformation.tetPhone.text.toString()
            updateInformationViewModel.idNumber = dataBindingUpdateInformation.telIdNumber.text.toString()
            ShowLoading.show(this@UpdateInformationActivity)
            updateInformationViewModel.updateInformation(onSuccess = {
                ShowLoading.dismiss()
                ShowAlert.fail(this, dialogTitle = getString(R.string.alert_title_inform),message = getString(R.string.update_information_successfull), onClick = {
                    setResult(IntentActionKeys.KEY_RELOAD_DATA)
                    finish()
                })
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(this,dialogTitle = getString(R.string.alert_title_error), message = it)
            })
        }
    }
    
}

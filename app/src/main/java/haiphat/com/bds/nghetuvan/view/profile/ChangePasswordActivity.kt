package haiphat.com.bds.nghetuvan.view.profile

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityChangePasswordBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.profiles.ChangePasswordViewModel

class ChangePasswordActivity : BaseActivity() {

    private lateinit var dataBindingChangePassword: ActivityChangePasswordBinding
    private var changePasswordViewModel = ChangePasswordViewModel()

    override fun getContentView(): View {
        dataBindingChangePassword = DataBindingUtil.inflate(layoutInflater, R.layout.activity_change_password, null, false)
        dataBindingChangePassword.rippleSave.setOnRippleCompleteListener {
            changePassword()
        }
        dataBindingChangePassword.rippleBack.setOnRippleCompleteListener { this.onBackPressed() }
        return dataBindingChangePassword.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
    }


    private fun changePassword() {
        if (Validator().validate(dataBindingChangePassword)) {
            changePasswordViewModel.oldPassword = dataBindingChangePassword.telOldPassword.text.toString()
            changePasswordViewModel.newPassword = dataBindingChangePassword.tetPassword.text.toString()
            changePasswordViewModel.confirmPassword = dataBindingChangePassword.tetConfirmPassword.text.toString()
            ShowLoading.show(this@ChangePasswordActivity)
            changePasswordViewModel.changePassword(onSuccess = {
                ShowLoading.dismiss()
                ShowAlert.fail(this, dialogTitle = getString(R.string.alert_title_inform), message = getString(R.string.change_password_successfull), onClick = {
                    setResult(IntentActionKeys.KEY_RELOAD_DATA)
                    finish()
                })
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(this, dialogTitle = getString(R.string.alert_title_error), message = it)
            })
        }
    }
}

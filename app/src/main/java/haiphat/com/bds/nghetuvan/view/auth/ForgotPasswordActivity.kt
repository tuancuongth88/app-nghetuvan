package haiphat.com.bds.nghetuvan.view.auth

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityForgotPasswordBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.auth.ForgotPasswordViewModel

class ForgotPasswordActivity : BaseActivity() {

    private lateinit var dataBindingForgotPassword: ActivityForgotPasswordBinding
    private var forgotPasswordViewModel = ForgotPasswordViewModel()

    override fun getContentView(): View {
        dataBindingForgotPassword = DataBindingUtil.inflate(layoutInflater, R.layout.activity_forgot_password, null, false)
        dataBindingForgotPassword.rippleSendEmail.setOnRippleCompleteListener {
            forgotPassword()
        }
        return dataBindingForgotPassword.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingForgotPassword
        setHeaderVisibility(View.GONE)
    }

    private fun forgotPassword() {
        if (Validator().validate(dataBindingForgotPassword)) {
            forgotPasswordViewModel.email = dataBindingForgotPassword.tetEmail.text.toString().trim()
            ShowLoading.show(this@ForgotPasswordActivity)
            forgotPasswordViewModel.forgotPassword(onSuccess = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this, dialogTitle = getString(R.string.alert_title_inform), message = it, onClick = {
                    finish()
                })
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this, message = it)
            })
        }
    }
}

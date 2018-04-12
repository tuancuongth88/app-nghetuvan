package haiphat.com.bds.nghetuvan.view.auth

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityRegesterBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.auth.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var dataBindingRegister: ActivityRegesterBinding
    private var registerViewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingRegister = DataBindingUtil.setContentView(this@RegisterActivity, R.layout.activity_regester)
        dataBindingRegister.btnRegister.setOnClickListener {
            register()
        }
        dataBindingRegister.imgBack.setOnClickListener {
            this.onBackPressed()
        }
    }

    private fun register(){
        if (Validator().validate(dataBindingRegister)){
            registerViewModel.email = dataBindingRegister.tetEmail.text.toString()
            registerViewModel.fullName = dataBindingRegister.tetName.text.toString()
            registerViewModel.phone = dataBindingRegister.tetPhone.text.toString()
            registerViewModel.password = dataBindingRegister.tetPassword.text.toString()
            registerViewModel.confirmPassword = dataBindingRegister.tetConfirmPassword.text.toString()
            ShowLoading.show(this@RegisterActivity)
            registerViewModel.register(onSuccess = {
                ShowAlert.confirm(pContext = this, message = it, onClick = {
                    finish()
                })
                ShowLoading.dismiss()
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this@RegisterActivity, message = it)
            })
        }

    }
}

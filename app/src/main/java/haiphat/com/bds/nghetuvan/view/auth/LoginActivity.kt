package haiphat.com.bds.nghetuvan.view.auth

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityLoginBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.auth.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var dataBindingLogin : ActivityLoginBinding
    private var loginViewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingLogin = DataBindingUtil.setContentView(this, R.layout.activity_login)
        dataBindingLogin.btnLogin.setOnClickListener {
            loginEmail()
        }
        dataBindingLogin.tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        dataBindingLogin.txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

    }

    private fun loginEmail(){
        if (Validator().validate(dataBindingLogin)){
            loginViewModel.email = dataBindingLogin.tetEmail.text.toString().trim()
            loginViewModel.password = dataBindingLogin.tetPassword.text.toString().trim()
            ShowLoading.show(this@LoginActivity)
            loginViewModel.loginEmail(onSuccess = {
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                finish()
                ShowLoading.dismiss()
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this@LoginActivity, message = it)
            })
        }
    }

}

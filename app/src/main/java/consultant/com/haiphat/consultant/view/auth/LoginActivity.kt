package consultant.com.haiphat.consultant.view.auth

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import consultant.com.haiphat.consultant.R
import consultant.com.haiphat.consultant.databinding.ActivityLoginBinding
import consultant.com.haiphat.consultant.utils.dialog.ShowLoading
import consultant.com.haiphat.consultant.view.HomeActivity
import consultant.com.haiphat.consultant.viewmodel.auth.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var dataBindingLogin : ActivityLoginBinding
    private var loginViewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingLogin = DataBindingUtil.setContentView(this, R.layout.activity_login)
        dataBindingLogin.btnLogin.setOnClickListener {
            loginViewModel.email = dataBindingLogin.tetEmail.text.toString().trim()
            loginViewModel.password = dataBindingLogin.tetPassword.text.toString().trim()
            ShowLoading.show(this@LoginActivity)
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            }, 1000)
        }
        dataBindingLogin.btnRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        dataBindingLogin.txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

    }

}

package consultant.com.haiphat.consultant.view.auth

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import consultant.com.haiphat.consultant.R
import consultant.com.haiphat.consultant.databinding.ActivityRegesterBinding
import consultant.com.haiphat.consultant.utils.dialog.ShowAlert
import consultant.com.haiphat.consultant.utils.dialog.ShowLoading
import consultant.com.haiphat.consultant.view.HomeActivity
import consultant.com.haiphat.consultant.viewmodel.auth.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var dataBindingRegister : ActivityRegesterBinding
    private var registerViewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindingRegister = DataBindingUtil.setContentView(this@RegisterActivity, R.layout.activity_regester)
        dataBindingRegister.btnRegister.setOnClickListener{
            registerViewModel.email = dataBindingRegister.tetEmail.text.toString()
            registerViewModel.fullName = dataBindingRegister.tetName.text.toString()
            registerViewModel.phone = dataBindingRegister.tetPhone.text.toString()
            registerViewModel.password = dataBindingRegister.tetPassword.text.toString()
            ShowLoading.show(this@RegisterActivity)
            registerViewModel.register(onSuccess = {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@RegisterActivity, HomeActivity::class.java))
                }, 2000)
                ShowLoading.dismiss()
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this@RegisterActivity, message  = it)
            })
        }
    }
}

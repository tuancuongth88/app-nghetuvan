package haiphat.com.bds.nghetuvan.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.auth.LoginActivity
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.SplashViewModel


class SplashActivity : AppCompatActivity() {

    private var splashViewModel = SplashViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            autoActiveAccount()
//            var intentHome = Intent(this, HomeActivity::class.java)
//            intentActivity(intentHome)
        }, 2000)
    }

    private fun controlOpenMainScreen() {
        val bundle = intent.extras
        var intent = Intent(this, LoginActivity::class.java)
        UserServices.accessToken?.let {
            intent = Intent(this, HomeActivity::class.java)
        }

        if (bundle != null) {
            intent.putExtras(bundle)
        }
        intentActivity(intent)
    }

    private fun autoActiveAccount() {
        val intent = intent
        if (Intent.ACTION_VIEW != intent.action) {
            controlOpenMainScreen()
            return
        }
        if (intent.data.path.contains("/user/activation")) {
            var codeActive = intent.data.lastPathSegment
            activeAccount(codeActive)
        } else {
            controlOpenMainScreen()
        }
    }

    private fun activeAccount(codeActive : String?){
        var code = codeActive
        splashViewModel.activeAccount(code, onSuccess = {
            var intentHome = Intent(this, HomeActivity::class.java)
            intentActivity(intentHome)
        }, onFailed = {
            ShowAlert.fail(pContext = this@SplashActivity, dialogTitle = getString(R.string.alert_title_inform),
                    message = getString(R.string.text_no_internet_connection), onClick = {
                activeAccount(code)
            })
        })
    }

    private fun intentActivity(intent: Intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                or Intent.FLAG_ACTIVITY_CLEAR_TASK
                or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

}

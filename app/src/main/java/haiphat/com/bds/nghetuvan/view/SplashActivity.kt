package haiphat.com.bds.nghetuvan.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.view.auth.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            controlOpenMainScreen()
        }, 2000)
    }



    private fun controlOpenMainScreen() {
        val bundle = intent.extras
        var intent: Intent = Intent(this, LoginActivity::class.java)
        UserServices.accessToken?.let {
            intent = Intent(this, HomeActivity::class.java)
        }

        if (bundle != null) {
            intent.putExtras(bundle)
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                or Intent.FLAG_ACTIVITY_CLEAR_TASK
                or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}

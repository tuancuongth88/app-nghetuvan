package haiphat.com.bds.nghetuvan.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.view.auth.LoginActivity
import android.content.pm.PackageManager
import android.provider.SyncStateContract.Helpers.update
import com.facebook.FacebookSdk.getApplicationContext
import android.content.pm.PackageInfo
import android.app.Activity
import android.util.Base64
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


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


    fun printKeyHash(context: Activity): String? {
        val packageInfo: PackageInfo
        var key: String? = null
        try {
            //getting application package name, as defined in manifest
            val packageName = context.applicationContext.packageName

            //Retriving package info
            packageInfo = context.packageManager.getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES)

            print("Package Name=" +context.applicationContext.packageName)

            for (signature in packageInfo.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                key = String(Base64.encode(md.digest(), 0))

                // String key = new String(Base64.encodeBytes(md.digest()));
                print("Key Hash=" + key)
            }
        } catch (e1: PackageManager.NameNotFoundException) {
            print("Name not found"+ e1.toString())
        } catch (e: NoSuchAlgorithmException) {
            print("No such an algorithm"+ e.toString())
        } catch (e: Exception) {
            print("Exception"+ e.toString())
        }

        return key
    }
}

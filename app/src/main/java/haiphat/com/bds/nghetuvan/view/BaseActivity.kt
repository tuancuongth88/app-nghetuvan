package haiphat.com.bds.nghetuvan.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityHeaderBaseBinding
import haiphat.com.bds.nghetuvan.view.auth.LoginActivity

abstract class BaseActivity : AppCompatActivity() {

    lateinit var baseActivityBinding: ActivityHeaderBaseBinding

    private val logoutBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (!this@BaseActivity.isFinishing) {
                val pIntent = Intent(this@BaseActivity, LoginActivity::class.java)
                startActivity(pIntent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(this).registerReceiver(logoutBroadcastReceiver, IntentFilter(IntentActionKeys.FORCE_LOGOUT_ACTION))
    }

    override fun onStop() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(logoutBroadcastReceiver)
        super.onStop()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_header_base)
        baseActivityBinding.clContent.addView(getContentView(), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        baseActivityBinding.clContent.getChildAt(0).bringToFront()
        baseActivityBinding.rippleBack.setOnRippleCompleteListener { this.onBackPressed() }
        baseActivityBinding.rippleRight.visibility = View.GONE
    }


    fun setHeaderTitle(title: String?) {
        baseActivityBinding.tvTitle.text =title
    }

    fun setHeaderBackgroundColor(color : Int){
        baseActivityBinding.clHeader.setBackgroundColor(color)
    }

    fun setHeaderVisibility(visibility: Int) {
        baseActivityBinding.clHeader.visibility = visibility
    }

    override fun onBackPressed() {
        this.getCurrentFragment()?.let {
            if (it.onBackPressed()){
                return
            }
        }
        super.onBackPressed()
    }

    protected open fun getCurrentFragment(): BaseFragment?{
        return null
    }

    protected abstract fun getContentView(): View
}
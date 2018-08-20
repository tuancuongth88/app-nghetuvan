package haiphat.com.bds.nghetuvan.view.home

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityCategoryHomeBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.view.auth.LoginActivity

class CategoryHomeActivity : BaseActivity() {

    private lateinit var dataBindingCategoryHomeActivity : ActivityCategoryHomeBinding

    override fun getContentView(): View {
        dataBindingCategoryHomeActivity = DataBindingUtil.inflate(layoutInflater, R.layout.activity_category_home, null, false)
        dataBindingCategoryHomeActivity.rippleLoginEmail.setOnRippleCompleteListener {
            startActivity(Intent(this@CategoryHomeActivity, LoginActivity::class.java))
        }
        dataBindingCategoryHomeActivity.rippleInvestor.setOnRippleCompleteListener {
            startActivity(Intent(this@CategoryHomeActivity, HomeActivity::class.java))
        }
        dataBindingCategoryHomeActivity.rippleInvestors.setOnRippleCompleteListener {
            startActivity(Intent(this@CategoryHomeActivity, HomeActivity::class.java))
        }
        dataBindingCategoryHomeActivity.rippleCustomers.setOnRippleCompleteListener {
            startActivity(Intent(this@CategoryHomeActivity, HomeActivity::class.java))
        }
        dataBindingCategoryHomeActivity.rippleConsultants.setOnRippleCompleteListener {
            startActivity(Intent(this@CategoryHomeActivity, HomeActivity::class.java))
        }
        return dataBindingCategoryHomeActivity.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
    }
}

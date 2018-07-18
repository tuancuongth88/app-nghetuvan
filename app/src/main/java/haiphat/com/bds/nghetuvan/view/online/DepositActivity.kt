package haiphat.com.bds.nghetuvan.view.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityDepositBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.fragment.online.EnterCustomersInformationFragment
import haiphat.com.bds.nghetuvan.view.fragment.online.FindingCustomersFragment

class DepositActivity : BaseActivity() {

    private lateinit var dataBindingDeposit : ActivityDepositBinding


    override fun getContentView(): View {
        dataBindingDeposit = DataBindingUtil.inflate(layoutInflater, R.layout.activity_deposit, null, false)
        dataBindingDeposit.rbFindingCustomers.setOnClickListener {
            val fragmentFindingCustomers = FindingCustomersFragment()
            this.displayDepositActivities(fragmentFindingCustomers)
        }
        dataBindingDeposit.rbEnterCustomersInformation.setOnClickListener {
            val fragmentEnterCustomersInformation = EnterCustomersInformationFragment()
            this.displayDepositActivities(fragmentEnterCustomersInformation)
        }
        return dataBindingDeposit.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle("Yêu cầu giao dịch")
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))

        val fragmentFindingCustomers = FindingCustomersFragment()
        this.displayDepositActivities(fragmentFindingCustomers)

    }

    fun displayDepositActivities(depositActivitiesFragment: Fragment) {
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
        fragmentTransaction.replace(R.id.flContent, depositActivitiesFragment, "")
        fragmentTransaction.commitAllowingStateLoss()
    }

    override fun getCurrentFragment(): BaseFragment? {
        return supportFragmentManager.findFragmentById(R.id.flContent) as? BaseFragment
    }
}

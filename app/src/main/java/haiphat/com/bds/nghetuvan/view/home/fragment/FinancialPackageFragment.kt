package haiphat.com.bds.nghetuvan.view.home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentFinancialPackageBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsInfoBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.HomeInfoViewModel
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class FinancialPackageFragment : BaseFragment() {
    private lateinit var dataBindingFragmentFinancialPackage: FragmentFinancialPackageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentFinancialPackage = DataBindingUtil.inflate(inflater, R.layout.fragment_financial_package, container, false)
        return dataBindingFragmentFinancialPackage.root
    }


    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): FinancialPackageFragment {
            val fragment = FinancialPackageFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}
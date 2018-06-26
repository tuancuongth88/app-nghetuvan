package haiphat.com.bds.nghetuvan.view.home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentFinancialPackageBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class FinancialPackageFragment : BaseFragment() , SwipeRefreshLayout.OnRefreshListener {

    private lateinit var dataBindingFragmentFinancialPackage: FragmentFinancialPackageBinding
    private val urlWeb = "https://nghemoigioi.vn/goi-vay/cau-giay-center-point-goi-vay-ngan-hang-vietcombank/"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentFinancialPackage = DataBindingUtil.inflate(inflater, R.layout.fragment_financial_package, container, false)
        dataBindingFragmentFinancialPackage.swipeRefreshLayout.setOnRefreshListener(this)
        dataBindingFragmentFinancialPackage.swipeRefreshLayout.isRefreshing = true
        loadData()
        return dataBindingFragmentFinancialPackage.root
    }

    private fun loadData(){
        dataBindingFragmentFinancialPackage.webFinancialPackage.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                dataBindingFragmentFinancialPackage.swipeRefreshLayout.isRefreshing = false
                super.onPageFinished(view, url)
            }

        }
        dataBindingFragmentFinancialPackage.webFinancialPackage.loadUrl(urlWeb)

    }

    override fun onRefresh() {
        dataBindingFragmentFinancialPackage.swipeRefreshLayout.isRefreshing = true
        loadData()
    }

    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): FinancialPackageFragment {
            val fragment = FinancialPackageFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}
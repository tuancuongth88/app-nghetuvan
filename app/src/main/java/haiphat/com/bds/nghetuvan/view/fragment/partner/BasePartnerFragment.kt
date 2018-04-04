package haiphat.com.bds.nghetuvan.view.fragment.partner

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentBaseNewsBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentBasePartnerBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.view.fragment.news.NewsFragment
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class BasePartnerFragment : BaseFragment() {
    private lateinit var dataBindingFragmentPartner: FragmentBasePartnerBinding
    private var newsViewModel = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_base_partner, container, false)
        getCategory()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        initViewPager()
        return dataBindingFragmentPartner.root
    }

    private fun getCategory() {
        ShowLoading.show(activity)
        newsViewModel.getItemNews(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
            }, 1000)
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }


    private fun initViewPager() {
        val sectionsPagerAdapter = SectionsPagerPartnerAdapter(childFragmentManager)
        dataBindingFragmentPartner.container.adapter = sectionsPagerAdapter
        dataBindingFragmentPartner.tabs.setupWithViewPager(dataBindingFragmentPartner.container)
        dataBindingFragmentPartner.tabs.setTabTextColors(ContextCompat.getColor(context!!, R.color.colorWhite), ContextCompat.getColor(context!!, R.color.colorWhite))
    }

    inner class SectionsPagerPartnerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return NewsFragment()
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Chủ đầu tư"
                1 -> return "Ngân hàng"
            }
            return null
        }
    }
}
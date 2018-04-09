package haiphat.com.bds.nghetuvan.view.fragment.partner

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.NewsAdapter
import haiphat.com.bds.nghetuvan.adapter.partner.PartnerAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentBaseNewsBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentBasePartnerBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentPartnerBinding
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.view.fragment.news.NewsFragment
import haiphat.com.bds.nghetuvan.view.news.DetailNewsActivity
import haiphat.com.bds.nghetuvan.view.partner.PartnerDetailActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsViewModel
import haiphat.com.bds.nghetuvan.viewmodel.partner.PartnerViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class BasePartnerFragment : BaseFragment() {
    private lateinit var dataBindingFragmentPartner: FragmentBasePartnerBinding
    private var partnerViewModel = PartnerViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_base_partner, container, false)
        getCategory()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        initViewPager()
        return dataBindingFragmentPartner.root
    }

    private fun getCategory() {
        ShowLoading.show(activity)
        partnerViewModel.getCategoryPartner(onSuccess = {
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
            return ContentFragment()
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

    class ContentFragment : BaseFragment() , SwipeRefreshLayout.OnRefreshListener{
        private lateinit var dataBindingFragmentPartner: FragmentPartnerBinding
        private var partnerViewModel = PartnerViewModel()

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_partner, container, false)
            getItemPartner()
            dataBindingFragmentPartner.swipeRefreshLayout.setOnRefreshListener(this)
            return dataBindingFragmentPartner.root
        }

        private fun initPartnerAdapter(list : ArrayList<PartnerResponse>){
            var recyclerView = dataBindingFragmentPartner.rvNews
            var adapter = PartnerAdapter(list, onClick = {
                startActivity(Intent(activity, PartnerDetailActivity::class.java))
            })
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        }

        private fun getItemPartner(){
            ShowLoading.show(activity)
            partnerViewModel.getItemPartner(onSuccess = {
                Handler(Looper.getMainLooper()).postDelayed({
                    ShowLoading.dismiss()
                    dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
                    initPartnerAdapter(it)
                }, 1000)
            }, onFailed = {
                ShowLoading.dismiss()
                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
                ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
            })
        }

        override fun onRefresh() {
            dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = true
            getItemPartner()
        }


    }
}
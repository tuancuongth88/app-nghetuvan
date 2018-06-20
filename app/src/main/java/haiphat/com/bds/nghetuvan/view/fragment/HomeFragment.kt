package haiphat.com.bds.nghetuvan.view.fragment

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
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.partner.PartnerAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentHomeBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentPartnerBinding
import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.view.partner.PartnerDetailActivity
import haiphat.com.bds.nghetuvan.viewmodel.HomePageViewModel
import haiphat.com.bds.nghetuvan.viewmodel.partner.PartnerViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class HomeFragment : BaseFragment() {
    private lateinit var dataBindingFragmentHome: FragmentHomeBinding
    private var homePageViewModel = HomePageViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentHome = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        getCategoryHome()
        context?.let{
            (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        }
        return dataBindingFragmentHome.root
    }

    private fun getCategoryHome() {
        ShowLoading.show(activity)
        homePageViewModel.getItemHomePage(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                val sectionsAdapter = SectionsPagerHomeAdapter(childFragmentManager)
                sectionsAdapter.listCategoryPartner = it
                dataBindingFragmentHome.container.adapter = sectionsAdapter
                dataBindingFragmentHome.tabs.setupWithViewPager(dataBindingFragmentHome.container)
                dataBindingFragmentHome.tabs.setTabTextColors(ContextCompat.getColor(context!!, R.color.colorWhite), ContextCompat.getColor(context!!, R.color.colorWhite))

                ShowLoading.dismiss()
            }, 1000)
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }

    inner class SectionsPagerHomeAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var listCategoryPartner = ArrayList<CategoryPartnerResponse>()

        override fun getItem(position: Int): Fragment {
            return ContentFragment.newInstance(listCategoryPartner.get(position).id)
        }

        override fun getCount(): Int {
            return listCategoryPartner.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return return listCategoryPartner.get(position).name
        }
    }


    class ContentFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {
        private lateinit var dataBindingFragmentPartner: FragmentPartnerBinding
        private var partnerViewModel = PartnerViewModel()

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_partner, container, false)
            getItemPartner()
            dataBindingFragmentPartner.swipeRefreshLayout.setOnRefreshListener(this)
            dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = true
            return dataBindingFragmentPartner.root
        }

        private fun initPartnerAdapter(list: ArrayList<PartnerResponse>) {
            var recyclerView = dataBindingFragmentPartner.rvNews
            var adapter = PartnerAdapter(list, onClick = {
                var intent = Intent(activity, PartnerDetailActivity::class.java)
                intent.putExtra(IntentActionKeys.KEY_DETAIL_NEWS, GsonUtil.toJson(it))
                startActivity(intent)
            })
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        }

        private fun getItemPartner() {
//            partnerViewModel.getItemPartner(onSuccess = {
//                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
//                initPartnerAdapter(it)
//            }, onFailed = {
//                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
//                ShowAlert.fail(pContext = activity, message = it)
//            })
        }

        override fun onRefresh() {
            dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = true
            getItemPartner()
        }

        companion object {
            fun newInstance(id: String?, arguments: Bundle? = null): ContentFragment {
                val fragment = ContentFragment()
                fragment.arguments = arguments
                fragment.partnerViewModel.id = id
                return fragment
            }
        }

    }
}

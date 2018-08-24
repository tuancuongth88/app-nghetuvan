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
import haiphat.com.bds.nghetuvan.adapter.home.HomeCategoryAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentHomeBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentHomeContentBinding
import haiphat.com.bds.nghetuvan.models.home.HomeCategoryResponse
import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.view.home.ShowListHomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.home.HomePageViewModel

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
            return ContentFragment.newInstance(listCategoryPartner[position].id.toString())
        }

        override fun getCount(): Int {
            return listCategoryPartner.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return return listCategoryPartner[position].name
        }
    }


    class ContentFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {
        private lateinit var dataBindingFragmentHomeContent: FragmentHomeContentBinding
        private var homePageViewModel = HomePageViewModel()

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            dataBindingFragmentHomeContent = DataBindingUtil.inflate(inflater, R.layout.fragment_home_content, container, false)
            dataBindingFragmentHomeContent.swipeRefreshLayout.setOnRefreshListener(this)
            dataBindingFragmentHomeContent.swipeRefreshLayout.isRefreshing = true
            getItemHome()
            return dataBindingFragmentHomeContent.root
        }

        private fun initHomeContentAdapter(list: ArrayList<HomeCategoryResponse>) {
            val recyclerView = dataBindingFragmentHomeContent.rvHomeContent
            val adapter = HomeCategoryAdapter(list, onClick = {
                val intent = Intent(activity, ShowListHomeActivity::class.java)
//                intent.putExtra(IntentActionKeys.KEY_DETAIL_NEWS, GsonUtil.toJson(it))
                startActivity(intent)
            })
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        }

        private fun getItemHome() {
            homePageViewModel.getHomeCategory(onSuccess = {
                dataBindingFragmentHomeContent.swipeRefreshLayout.isRefreshing = false
                initHomeContentAdapter(it)
            }, onFailed = {
                dataBindingFragmentHomeContent.swipeRefreshLayout.isRefreshing = false
                ShowAlert.fail(pContext = activity, message = it)
            })
        }

        override fun onRefresh() {
            dataBindingFragmentHomeContent.swipeRefreshLayout.isRefreshing = true
            getItemHome()
        }

        companion object {
            fun newInstance(id: String?, arguments: Bundle? = null): ContentFragment {
                val fragment = ContentFragment()
                fragment.arguments = arguments
                return fragment
            }
        }

    }
}

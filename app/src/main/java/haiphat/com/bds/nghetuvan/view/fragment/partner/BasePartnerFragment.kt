package haiphat.com.bds.nghetuvan.view.fragment.partner

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
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
import haiphat.com.bds.nghetuvan.databinding.FragmentBasePartnerBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentPartnerBinding
import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.view.partner.PartnerDetailActivity
import haiphat.com.bds.nghetuvan.viewmodel.partner.PartnerViewModel

class BasePartnerFragment : BaseFragment() {
    private lateinit var dataBindingFragmentPartner: FragmentBasePartnerBinding
    private var partnerViewModel = PartnerViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_base_partner, container, false)
        getCategory()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        return dataBindingFragmentPartner.root
    }

    private fun getCategory() {
        ShowLoading.show(activity)
        partnerViewModel.getCategoryPartner(onSuccess = {
            val sectionsPagerAdapter = SectionsPagerPartnerAdapter(childFragmentManager)
            it?.let {
                sectionsPagerAdapter.listCategoryPartner = it
            }
            dataBindingFragmentPartner.container.adapter = sectionsPagerAdapter
            dataBindingFragmentPartner.tabs.setupWithViewPager(dataBindingFragmentPartner.container)
            dataBindingFragmentPartner.tabs.setTabTextColors(ContextCompat.getColor(context!!, R.color.colorWhite), ContextCompat.getColor(context!!, R.color.colorWhite))
            ShowLoading.dismiss()
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = it)
        })
    }


    inner class SectionsPagerPartnerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var listCategoryPartner = ArrayList<CategoryPartnerResponse>()

        override fun getItem(position: Int): Fragment {
            return ContentFragment.newInstance(listCategoryPartner[position].id.toString())
        }

        override fun getCount(): Int {
            return listCategoryPartner.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listCategoryPartner[position].name
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

        private fun initPartnerAdapter(list: ArrayList<PartnerResponse>?) {
            val recyclerView = dataBindingFragmentPartner.rvNews
            val adapter = PartnerAdapter(list, onClick = {
                val intent = Intent(activity, PartnerDetailActivity::class.java)
                intent.putExtra(IntentActionKeys.KEY_DETAIL_NEWS, it?.let { it1 -> GsonUtil.toJson(it1) })
                startActivity(intent)
            })
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        }

        private fun getItemPartner() {
            partnerViewModel.getItemPartner(onSuccess = {
                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
                initPartnerAdapter(it)
            }, onFailed = {
                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
                ShowAlert.fail(pContext = activity, message = it)
            })
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
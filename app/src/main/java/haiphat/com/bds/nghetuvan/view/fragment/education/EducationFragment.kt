package haiphat.com.bds.nghetuvan.view.fragment.education

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
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.education.EducationAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentEducationBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentPartnerBinding
import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.education.EducationDetailActivity
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.education.EducationViewModel

class EducationFragment : BaseFragment() {
    private lateinit var dataBindingFragmentPartner: FragmentEducationBinding
    private var educationViewModel = EducationViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_education, container, false)
        getCategory()
        getEducationHot()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        return dataBindingFragmentPartner.root
    }

    private fun getCategory() {
        ShowLoading.show(activity)
        educationViewModel.getCategoryEducation(onSuccess = {
            val sectionsPagerAdapter = SectionsPagerEducationAdapter(childFragmentManager)
            it?.let { sectionsPagerAdapter.listCategoryEducation = it }
            dataBindingFragmentPartner.container.adapter = sectionsPagerAdapter
            dataBindingFragmentPartner.tabs.setupWithViewPager(dataBindingFragmentPartner.container)
            dataBindingFragmentPartner.tabs.setTabTextColors(ContextCompat.getColor(context!!, R.color.colorWhite), ContextCompat.getColor(context!!, R.color.colorWhite))
            ShowLoading.dismiss()
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = it)
        })
    }

    private fun getEducationHot(){
        educationViewModel.getHotItems(onSuccess = {
        }, onFailed = {
            ShowAlert.fail(pContext = activity, message = it)
        })
    }

    inner class SectionsPagerEducationAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var listCategoryEducation = ArrayList<BaseResponse>()

        override fun getItem(position: Int): Fragment {
            return ContentFragment.newInstance(listCategoryEducation?.get(position)?.id)
        }

        override fun getCount(): Int {
            return listCategoryEducation.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listCategoryEducation[position].name
        }
    }

    class ContentFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {
        private lateinit var dataBindingFragmentPartner: FragmentPartnerBinding
        private var educationViewModel = EducationViewModel()

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            dataBindingFragmentPartner = DataBindingUtil.inflate(inflater, R.layout.fragment_partner, container, false)
            dataBindingFragmentPartner.swipeRefreshLayout.setOnRefreshListener(this)
            dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = true
            getItemEducations()
            return dataBindingFragmentPartner.root
        }

        private fun initPartnerAdapter(list: ArrayList<EducationResponse>?) {
            val recyclerView = dataBindingFragmentPartner.rvNews
            val adapter = EducationAdapter(list, onClick = {
                val intent = Intent(activity, EducationDetailActivity::class.java)
                intent.putExtra(IntentActionKeys.KEY_ITEM_EDUCATION, it?.let { it1 -> GsonUtil.toJson(it1) })
                startActivity(intent)
            })
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        }

        private fun getItemEducations() {
            educationViewModel.getItemEducation(onSuccess = {
                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
                initPartnerAdapter(it)
            }, onFailed = {
                dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = false
                ShowAlert.fail(pContext = activity, message = it)
            })
        }

        override fun onRefresh() {
            dataBindingFragmentPartner.swipeRefreshLayout.isRefreshing = true
            getItemEducations()
        }

        companion object {
            fun newInstance(id: Int?, arguments: Bundle? = null): ContentFragment {
                val fragment = ContentFragment()
                fragment.educationViewModel.id = id
                fragment.arguments = arguments
                return fragment
            }
        }

    }
}
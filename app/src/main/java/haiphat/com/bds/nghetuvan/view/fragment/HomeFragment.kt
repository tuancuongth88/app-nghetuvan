package haiphat.com.bds.nghetuvan.view.fragment

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.HomeAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentHomeBinding
import haiphat.com.bds.nghetuvan.models.HomePageCategoryType
import haiphat.com.bds.nghetuvan.models.HomePageResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.news.NewsActivity
import haiphat.com.bds.nghetuvan.viewmodel.HomePageViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class HomeFragment : BaseFragment() {
    private lateinit var dataBindingFragmentHome: FragmentHomeBinding
    private var homePageViewModel = HomePageViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentHome = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        getItemHomePage()
        return dataBindingFragmentHome.root
    }

    private fun initHomeAdapter(list: ArrayList<HomePageResponse>) {
        var recyclerview = dataBindingFragmentHome.rvHome
        recyclerview.layoutManager = GridLayoutManager(activity, 2)
        var adapter = HomeAdapter(list, onClick = {
            when (it.type ?: HomePageCategoryType.HomeGeneralNews) {
                HomePageCategoryType.HomeGeneralNews -> {
                    startActivity(Intent(activity, NewsActivity::class.java))
                }
                HomePageCategoryType.HomeInvestor -> {

                }
                else ->{
                    startActivity(Intent(activity, NewsActivity::class.java))
                }
            }
        })
        recyclerview.adapter = adapter
    }

    private fun getItemHomePage() {
        ShowLoading.show(activity)
        homePageViewModel.getItemHomePage(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
                initHomeAdapter(it)
            }, 1000)
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }

    companion object {
        fun newInstance(arguments: Bundle? = null): HomeFragment {
            val fragment = HomeFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}

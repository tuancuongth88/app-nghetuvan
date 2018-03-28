package consultant.com.haiphat.consultant.view.fragment

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import consultant.com.haiphat.consultant.R
import consultant.com.haiphat.consultant.adapter.HomeAdapter
import consultant.com.haiphat.consultant.databinding.FragmentHomeBinding
import consultant.com.haiphat.consultant.models.HomePageCategoryType
import consultant.com.haiphat.consultant.models.HomePageResponse
import consultant.com.haiphat.consultant.models.profiles.ProfileModel
import consultant.com.haiphat.consultant.utils.dialog.ShowAlert
import consultant.com.haiphat.consultant.utils.dialog.ShowLoading
import consultant.com.haiphat.consultant.view.BaseFragment
import consultant.com.haiphat.consultant.view.news.NewsActivity
import consultant.com.haiphat.consultant.viewmodel.HomePageViewModel

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

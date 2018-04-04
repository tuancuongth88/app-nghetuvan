package haiphat.com.bds.nghetuvan.view.fragment.news

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
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class BaseNewsFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNews: FragmentBaseNewsBinding
    private var newsViewModel = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNews = DataBindingUtil.inflate(inflater, R.layout.fragment_base_news, container, false)
        getCategory()
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        initViewPager()
        return dataBindingFragmentNews.root
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
        val sectionsPagerAdapter = SectionsPagerNewsAdapter(childFragmentManager)
        dataBindingFragmentNews.container.adapter = sectionsPagerAdapter
        dataBindingFragmentNews.tabs.setupWithViewPager(dataBindingFragmentNews.container)
        dataBindingFragmentNews.tabs.setTabTextColors(ContextCompat.getColor(context!!, R.color.colorWhite), ContextCompat.getColor(context!!, R.color.colorWhite))
    }

    inner class SectionsPagerNewsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return NewsFragment()
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return BaseApplication.context.getString(R.string.text_tab_news_info)
                1 -> return BaseApplication.context.getString(R.string.text_tab_news_comment)
            }
            return null
        }
    }
}
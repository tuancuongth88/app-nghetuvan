package haiphat.com.bds.nghetuvan.view.fragment.news

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentBaseNewsBinding
import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsViewModel
import java.util.*

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class BaseNewsFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNews: FragmentBaseNewsBinding
    private var newsViewModel = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNews = DataBindingUtil.inflate(inflater, R.layout.fragment_base_news, container, false)
        (activity as HomeActivity).setBackgroundColor(Color.TRANSPARENT)
        getCategory()
        return dataBindingFragmentNews.root
    }

    private fun getCategory() {
        ShowLoading.show(activity)
        newsViewModel.getCategoryNews(onSuccess = {
            val sectionsPagerAdapter = SectionsPagerNewsAdapter(childFragmentManager)
            sectionsPagerAdapter.listItemNews = it
            dataBindingFragmentNews.container.adapter = sectionsPagerAdapter
            dataBindingFragmentNews.tabs.setupWithViewPager(dataBindingFragmentNews.container)
            dataBindingFragmentNews.tabs.setTabTextColors(ContextCompat.getColor(context!!, R.color.colorWhite), ContextCompat.getColor(context!!, R.color.colorWhite))
            ShowLoading.dismiss()
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = it)
        })
    }

    inner class SectionsPagerNewsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var listItemNews = ArrayList<CategoryNewsResponse>()

        override fun getItem(position: Int): Fragment {
            return NewsFragment.newInstance(listItemNews.get(position).id)
        }

        override fun getCount(): Int {
            return listItemNews.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listItemNews.get(position).name
        }
    }
}
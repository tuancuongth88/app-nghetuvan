package haiphat.com.bds.nghetuvan.adapter.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.view.fragment.news.detail.NewsCommentFragment
import haiphat.com.bds.nghetuvan.view.fragment.news.detail.NewsInfoFragment
import haiphat.com.bds.nghetuvan.view.home.fragment.HomeInfoFragment

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class SectionsPagerHomeAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var newsResponse : NewsResponse? =null

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = HomeInfoFragment.newInstance(newsResponse?.content)
            }
            1 -> {
                fragment = NewsCommentFragment.newInstance(newsResponse?.id)
            }
            2 -> {
                fragment = NewsCommentFragment.newInstance(newsResponse?.id)
            }
            3 -> {
                fragment = NewsCommentFragment.newInstance(newsResponse?.id)
            }
        }
        return fragment ?: NewsInfoFragment.newInstance(newsResponse?.content)
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return BaseApplication.context.getString(R.string.text_tab_news_info)
            1 -> return "Quản lý dự án"
            2 -> return "Gói tài chính"
            3 -> return "Tài liệu"
        }
        return null
    }
}
package haiphat.com.bds.nghetuvan.adapter.news

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.view.fragment.news.detail.NewsCommentFragment
import haiphat.com.bds.nghetuvan.view.fragment.news.detail.NewsInfoFragment

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class SectionsPagerNewsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var newsResponse : NewsResponse? =null

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = NewsInfoFragment.newInstance(newsResponse?.content)
            }
            1 -> {
                fragment = NewsCommentFragment.newInstance(newsResponse?.id)
            }
        }
        return fragment ?: NewsInfoFragment.newInstance(newsResponse?.content)
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
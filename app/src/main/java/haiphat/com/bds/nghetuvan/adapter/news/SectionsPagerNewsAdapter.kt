package haiphat.com.bds.nghetuvan.adapter.news

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.view.fragment.news.NewsCommentFragment
import haiphat.com.bds.nghetuvan.view.fragment.news.NewsInfoFragment

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class SectionsPagerNewsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = NewsInfoFragment.newInstance()
            }
            1 -> {
                fragment = NewsCommentFragment.newInstance()
            }
        }
        return fragment ?: NewsInfoFragment.newInstance()
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
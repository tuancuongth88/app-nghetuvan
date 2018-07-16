package haiphat.com.bds.nghetuvan.adapter.online

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.view.home.fragment.DocumentFragment
import haiphat.com.bds.nghetuvan.view.home.fragment.FinancialPackageFragment
import haiphat.com.bds.nghetuvan.view.home.fragment.HomeInfoFragment
import haiphat.com.bds.nghetuvan.view.home.fragment.ProjectManagementFragment

class SectionsPagerDetailOnlineSalesAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var newsResponse : NewsResponse? =null

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = HomeInfoFragment.newInstance(newsResponse?.content)
            }
            1 -> {
                fragment = ProjectManagementFragment.newInstance(newsResponse?.id)
            }
        }
        return fragment ?: HomeInfoFragment.newInstance(newsResponse?.content)
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return BaseApplication.context.getString(R.string.text_tab_news_info)
            1 -> return "Vị trí căn hộ"
        }
        return null
    }
}
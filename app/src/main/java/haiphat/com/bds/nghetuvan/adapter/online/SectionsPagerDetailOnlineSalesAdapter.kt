package haiphat.com.bds.nghetuvan.adapter.online

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.view.fragment.online.ApartmentLocationFragment
import haiphat.com.bds.nghetuvan.view.fragment.online.OnlineSalesInfoFragment

class SectionsPagerDetailOnlineSalesAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = OnlineSalesInfoFragment()
            }
            1, 2 -> {
                fragment = ApartmentLocationFragment()
            }
        }
        return fragment ?: OnlineSalesInfoFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return BaseApplication.context.getString(R.string.text_tab_news_info)
            1 -> return "Vị trí căn hộ"
            2 -> return "Phản hồi 3D"
        }
        return null
    }
}
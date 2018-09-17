package haiphat.com.bds.nghetuvan.adapter.project

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.project.ProjectWarehouseResponse
import haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.detail.ProjectSupportFragment
import haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.detail.ProjectInfoFragment
import haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.detail.ProjectUtilitiesFragment

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class SectionsPagerProjectAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var projectResponse : ProjectWarehouseResponse? =null

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0, 1 -> {
                fragment = ProjectInfoFragment.newInstance(projectResponse?.description)
            }
            2 -> {
                fragment = ProjectSupportFragment.newInstance(projectResponse?.description)
            }
            3 -> {
                fragment = ProjectSupportFragment.newInstance(projectResponse?.description)
            }
            4 -> {
                fragment = ProjectUtilitiesFragment()
            }
            5 -> {
                fragment = ProjectSupportFragment.newInstance(projectResponse?.description)
            }
        }
        return fragment ?: ProjectInfoFragment.newInstance(projectResponse?.description)
    }

    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return BaseApplication.context.getString(R.string.txt_project_table_info)
            1 -> return BaseApplication.context.getString(R.string.txt_project_table_investor)
            2 -> return BaseApplication.context.getString(R.string.txt_project_table_sales_policy)
            3 -> return BaseApplication.context.getString(R.string.txt_project_table_model_house)
            4 -> return BaseApplication.context.getString(R.string.txt_project_table_utilities)
            5 -> return BaseApplication.context.getString(R.string.txt_project_table_support)
        }
        return null
    }
}
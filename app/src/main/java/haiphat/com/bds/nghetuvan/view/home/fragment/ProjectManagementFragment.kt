package haiphat.com.bds.nghetuvan.view.home.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentProjectManagementBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProjectManagementFragment : BaseFragment() {
    private lateinit var dataBindingFragmentProjectManagement: FragmentProjectManagementBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentProjectManagement = DataBindingUtil.inflate(inflater, R.layout.fragment_project_management, container, false)
        return dataBindingFragmentProjectManagement.root
    }


    companion object {
        fun newInstance(content: String?, arguments: Bundle? = null): ProjectManagementFragment {
            val fragment = ProjectManagementFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}
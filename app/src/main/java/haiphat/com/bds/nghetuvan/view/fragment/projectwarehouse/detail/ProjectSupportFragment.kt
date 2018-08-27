package haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse.detail

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.project.ProjectSupportAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentProjectSupportBinding
import haiphat.com.bds.nghetuvan.models.project.ProjectSupportResponse
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.project.ProjectSupportViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProjectSupportFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var dataBindingFragmentNewsComment: FragmentProjectSupportBinding
    private var projectSupportViewModel = ProjectSupportViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsComment = DataBindingUtil.inflate(inflater, R.layout.fragment_project_support, container, false)
        dataBindingFragmentNewsComment.swipeRefreshLayout.setOnRefreshListener(this)
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
        getItemSupport()
        return dataBindingFragmentNewsComment.root
    }

    private fun initSupportAdapter(list: ArrayList<ProjectSupportResponse>?) {
        val recyclerview = dataBindingFragmentNewsComment.rvNewsComment
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val adapter = ProjectSupportAdapter(list)
        recyclerview.adapter = adapter
    }

    private fun getItemSupport(){
        projectSupportViewModel.getItemsSupport(onSuccess = {
            dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = false
            initSupportAdapter(it)
        }, onFailed = {
            dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = false
        })
    }

    override fun onRefresh() {
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
        getItemSupport()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == IntentActionKeys.KEY_RELOAD_DATA){
            onRefresh()
        }
    }

    companion object {
        fun newInstance(id: String?, arguments: Bundle? = null): ProjectSupportFragment {
            val fragment = ProjectSupportFragment()
            fragment.projectSupportViewModel.id = id
            fragment.arguments = arguments
            return fragment
        }
    }
}
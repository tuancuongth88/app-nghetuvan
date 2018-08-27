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
import haiphat.com.bds.nghetuvan.adapter.news.NewsDetailCommentAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentProjectSupportBinding
import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ProjectSupportFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var dataBindingFragmentNewsComment: FragmentProjectSupportBinding
    private var newsCommentViewModel = NewsCommentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsComment = DataBindingUtil.inflate(inflater, R.layout.fragment_project_support, container, false)
        dataBindingFragmentNewsComment.swipeRefreshLayout.setOnRefreshListener(this)
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
        return dataBindingFragmentNewsComment.root
    }

    private fun initNewsCommentAdapter(list: ArrayList<NewsCommentResponse>) {
        val recyclerview = dataBindingFragmentNewsComment.rvNewsComment
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val adapter = NewsDetailCommentAdapter(list)
        recyclerview.adapter = adapter
    }


    override fun onRefresh() {
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
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
            fragment.newsCommentViewModel.newsId = id
            fragment.arguments = arguments
            return fragment
        }
    }
}
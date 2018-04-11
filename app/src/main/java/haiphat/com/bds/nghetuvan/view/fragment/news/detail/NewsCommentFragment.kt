package haiphat.com.bds.nghetuvan.view.fragment.news.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.NewsDetailCommentAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsCommentBinding
import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsCommentFragment : BaseFragment() , SwipeRefreshLayout.OnRefreshListener{

    private lateinit var dataBindingFragmentNewsComment: FragmentNewsCommentBinding
    private var newsCommentViewModel = NewsCommentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsComment = DataBindingUtil.inflate(inflater, R.layout.fragment_news_comment, container, false)
        getItemComment()
        dataBindingFragmentNewsComment.swipeRefreshLayout.setOnRefreshListener(this)
        return dataBindingFragmentNewsComment.root
    }

    private fun initNewsCommentAdapter(list: ArrayList<NewsCommentResponse>) {
        var recyclerview = dataBindingFragmentNewsComment.rvNewsComment
        recyclerview.layoutManager = LinearLayoutManager(activity)
        var adapter = NewsDetailCommentAdapter(list)
        recyclerview.adapter = adapter
    }

    private fun getItemComment() {
        ShowLoading.show(activity)
        newsCommentViewModel.getListComment(onSuccess = {
            initNewsCommentAdapter(it)
            ShowLoading.dismiss()
            dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = false
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = it)
            dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = false
        })
    }

    override fun onRefresh() {
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
        getItemComment()
    }
    companion object {
        fun newInstance(id: String?, arguments: Bundle? = null): NewsCommentFragment {
            val fragment = NewsCommentFragment()
            fragment.newsCommentViewModel.id = id
            fragment.arguments = arguments
            return fragment
        }
    }
}
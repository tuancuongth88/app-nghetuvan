package haiphat.com.bds.nghetuvan.view.fragment.news.detail

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
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsCommentBinding
import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.news.PostCommentActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsCommentFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var dataBindingFragmentNewsComment: FragmentNewsCommentBinding
    private var newsCommentViewModel = NewsCommentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsComment = DataBindingUtil.inflate(inflater, R.layout.fragment_news_comment, container, false)
        getItemComment()
        dataBindingFragmentNewsComment.swipeRefreshLayout.setOnRefreshListener(this)
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
        dataBindingFragmentNewsComment.rippleComment.setOnRippleCompleteListener {
            val intent = Intent(activity, PostCommentActivity::class.java)
            intent.putExtra(IntentActionKeys.KEY_NEWS_ID, newsCommentViewModel.newsId)
            startActivityForResult(intent, IntentActionKeys.SCREEN_POST_COMMENT)
        }
        if (UserServices.userInfo == null) {
            dataBindingFragmentNewsComment.rippleComment.visibility = View.GONE
        }
        return dataBindingFragmentNewsComment.root
    }

    private fun initNewsCommentAdapter(list: ArrayList<NewsCommentResponse>) {
        val recyclerview = dataBindingFragmentNewsComment.rvNewsComment
        recyclerview.layoutManager = LinearLayoutManager(activity)
        val adapter = NewsDetailCommentAdapter(list)
        recyclerview.adapter = adapter
    }

    private fun getItemComment() {
        newsCommentViewModel.getListComment(onSuccess = {
            initNewsCommentAdapter(it)
            dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = false
        }, onFailed = {
            ShowAlert.fail(pContext = activity, message = it)
            dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = false
        })
    }


    override fun onRefresh() {
        dataBindingFragmentNewsComment.swipeRefreshLayout.isRefreshing = true
        getItemComment()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == IntentActionKeys.KEY_RELOAD_DATA){
            onRefresh()
        }
    }

    companion object {
        fun newInstance(id: String?, arguments: Bundle? = null): NewsCommentFragment {
            val fragment = NewsCommentFragment()
            fragment.newsCommentViewModel.newsId = id
            fragment.arguments = arguments
            return fragment
        }
    }
}
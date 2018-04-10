package haiphat.com.bds.nghetuvan.view.fragment.news.detail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.NewsDetailCommentAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsCommentBinding
import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsCommentFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNewsComment: FragmentNewsCommentBinding
    private var newsCommentViewModel = NewsCommentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNewsComment = DataBindingUtil.inflate(inflater, R.layout.fragment_news_comment, container, false)
//        getItem()
        return dataBindingFragmentNewsComment.root
    }

    private fun initNewsCommentAdapter(list: ArrayList<NewsCommentResponse>) {
        var recyclerview = dataBindingFragmentNewsComment.rvNewsComment
        recyclerview.layoutManager = LinearLayoutManager(activity)
        var adapter = NewsDetailCommentAdapter(list)
        recyclerview.adapter = adapter
    }

//    private fun getItem() {
//        ShowLoading.show(activity)
//        newsCommentViewModel.getItemNewsComment(onSuccess = {
//            Handler(Looper.getMainLooper()).postDelayed({
//                initNewsCommentAdapter(it)
//            }, 1000)
//        }, onFailed = {
//
//        })
//    }


    companion object {
        fun newInstance(arguments: Bundle? = null): NewsCommentFragment {
            val fragment = NewsCommentFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}
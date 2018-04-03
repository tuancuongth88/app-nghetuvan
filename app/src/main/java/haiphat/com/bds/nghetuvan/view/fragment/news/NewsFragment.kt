package haiphat.com.bds.nghetuvan.view.fragment.news

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.NewsAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentBaseNewsBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentNewsBinding
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.HomeActivity
import haiphat.com.bds.nghetuvan.view.news.DetailNewsActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsViewModel

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsFragment : BaseFragment() {
    private lateinit var dataBindingFragmentNews: FragmentNewsBinding
    private var newsViewModel = NewsViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentNews = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        getItemNews()
        return dataBindingFragmentNews.root
    }


    private fun initNewsAdapter(list: ArrayList<NewsResponse>) {
        var recyclerView = dataBindingFragmentNews.rvNews
        var adapter = NewsAdapter(list, onClick = {
            startActivity(Intent(activity, DetailNewsActivity::class.java))
        })
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun getItemNews() {
        ShowLoading.show(activity)
        newsViewModel.getItemNews(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
                initNewsAdapter(it)
            }, 1000)
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }


//    companion object {
//        fun newInstance(arguments: Bundle? = null): NewsFragment {
//            val fragment = NewsFragment()
//            fragment.arguments = arguments
//            return fragment
//        }
//    }
}
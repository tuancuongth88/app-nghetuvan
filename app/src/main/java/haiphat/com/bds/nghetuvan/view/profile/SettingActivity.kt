package haiphat.com.bds.nghetuvan.view.profile

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.NewsAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivitySettingBinding
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.view.news.DetailNewsActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsViewModel

class SettingActivity : BaseActivity() {

    private lateinit var dataBindingNews : ActivitySettingBinding
    private var newsViewModel = NewsViewModel()

    override fun getContentView(): View {
        dataBindingNews = DataBindingUtil.inflate(layoutInflater, R.layout.activity_setting, null, false)
        getItemNews()
        return dataBindingNews.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle(getString(R.string.title_screen_news))
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
    }

    private fun initNewsAdapter(list : ArrayList<NewsResponse>){
        var recyclerView = dataBindingNews.rvNews
        var adapter = NewsAdapter(list, onClick = {
            startActivity(Intent(this@SettingActivity, DetailNewsActivity::class.java))
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun getItemNews(){
        ShowLoading.show(this)
        newsViewModel.getItemNews(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
                initNewsAdapter(it)
            }, 1000)
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this@SettingActivity, message = it)
        })
    }
}

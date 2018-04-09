package haiphat.com.bds.nghetuvan.view.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.SectionsPagerNewsAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailNewBinding
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailNewsBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.DetailNewsViewModel

class DetailNewsActivity : BaseActivity() {

    private lateinit var dataBindingDetailNews: ActivityDetailNewBinding
    private var detailNewsViewMode = DetailNewsViewModel()
    override fun getContentView(): View {
        dataBindingDetailNews = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_new, null, false)
        setSupportActionBar(dataBindingDetailNews.toolbar)
        dataBindingDetailNews.lnSplashBackground.visibility = View.VISIBLE
        dataBindingDetailNews.rippleBack.setOnRippleCompleteListener {
            onBackPressed()
        }
        dataBindingDetailNews.rippleSetting.setOnRippleCompleteListener {
            //Intent share facebook
        }
        return dataBindingDetailNews.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        getDetailNews()
        initViewPager()
    }

    private fun initViewPager() {
        val sectionsPagerAdapter = SectionsPagerNewsAdapter(supportFragmentManager)
        dataBindingDetailNews.container.adapter = sectionsPagerAdapter
        dataBindingDetailNews.tabs.setupWithViewPager(dataBindingDetailNews.container)
        dataBindingDetailNews.tabs.setTabTextColors(ContextCompat.getColor(this, R.color.colorWhite), ContextCompat.getColor(this, R.color.colorWhite))
    }


    private fun getDetailNews() {
        ShowLoading.show(this)
//        detailNewsViewMode.getDetailNews(onSuccess = {
//            Handler(Looper.getMainLooper()).postDelayed({
//                ShowLoading.dismiss()
//                dataBindingDetailNews.lnSplashBackground.visibility = View.GONE
//                dataBindingDetailNews.tvTitle.text = it.name
//            }, 1000)
//
//        }, onFailed = {
//            ShowLoading.dismiss()
//            ShowAlert.fail(pContext = this@DetailNewsActivity, message = getString(R.string.text_error))
//        })
    }

}

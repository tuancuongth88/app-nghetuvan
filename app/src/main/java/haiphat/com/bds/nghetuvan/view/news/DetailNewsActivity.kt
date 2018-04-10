package haiphat.com.bds.nghetuvan.view.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.news.SectionsPagerNewsAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailNewBinding
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.DetailNewsViewModel

class DetailNewsActivity : BaseActivity() {

    private lateinit var dataBindingDetailNews: ActivityDetailNewBinding
    override fun getContentView(): View {
        dataBindingDetailNews = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_new, null, false)
        setSupportActionBar(dataBindingDetailNews.toolbar)
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
        var bundle = intent.extras
        var newsResponse = GsonUtil.fromJson(bundle.getString(IntentActionKeys.KEY_DETAIL_NEWS), NewsResponse::class.java)
        dataBindingDetailNews.imCovert.fromUrl(newsResponse?.image_url, placeHolder = R.drawable.ic_defaul_bg_my_course)
        dataBindingDetailNews.tvName.text = newsResponse?.title
        val sectionsPagerAdapter = SectionsPagerNewsAdapter(supportFragmentManager)
        sectionsPagerAdapter.newsResponse = newsResponse
                dataBindingDetailNews.container.adapter = sectionsPagerAdapter
        dataBindingDetailNews.tabs.setupWithViewPager(dataBindingDetailNews.container)
        dataBindingDetailNews.tabs.setTabTextColors(ContextCompat.getColor(this, R.color.colorWhite), ContextCompat.getColor(this, R.color.colorWhite))

    }
}

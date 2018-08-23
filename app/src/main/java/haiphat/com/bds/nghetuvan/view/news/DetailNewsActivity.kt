package haiphat.com.bds.nghetuvan.view.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailNewBinding
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrlFixData
import haiphat.com.bds.nghetuvan.view.BaseActivity
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

class DetailNewsActivity : BaseActivity() {

    private lateinit var dataBindingDetailNews: ActivityDetailNewBinding
    override fun getContentView(): View {
        dataBindingDetailNews = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_new, null, false)
        setSupportActionBar(dataBindingDetailNews.toolbar)


        dataBindingDetailNews.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBar, verticalOffset ->
            if (verticalOffset == 0) {
                dataBindingDetailNews.tvTitle.visibility = View.GONE
            } else if (Math.abs(verticalOffset) >= appBar.totalScrollRange) {
                dataBindingDetailNews.tvName.visibility = View.GONE
                dataBindingDetailNews.tvTime.visibility = View.GONE
                dataBindingDetailNews.tvTitle.visibility = View.VISIBLE
            } else {
                dataBindingDetailNews.tvTitle.visibility = View.GONE
                dataBindingDetailNews.tvName.visibility = View.VISIBLE
                dataBindingDetailNews.tvTime.visibility = View.VISIBLE
            }
        })

        dataBindingDetailNews.rippleBack.setOnRippleCompleteListener {
            onBackPressed()
        }
        dataBindingDetailNews.rippleSetting.setOnRippleCompleteListener {
            CommonUtil.shareAppLinkViaFacebook(this,"https://developers.facebook.com")
        }
        return dataBindingDetailNews.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        val bundle = intent.extras
        val newsResponse = GsonUtil.fromJson(bundle.getString(IntentActionKeys.KEY_DETAIL_NEWS), NewsResponse::class.java)
        dataBindingDetailNews.imCovert.fromUrlFixData("http://media.haiphatland.com.vn" + newsResponse?.image_url, placeHolder = R.drawable.ic_defaul_bg_my_course)
        dataBindingDetailNews.tvName.text = newsResponse?.name
        dataBindingDetailNews.tvTitle.text = newsResponse?.name
        newsResponse?.content?.let { dataBindingDetailNews.htmTextContent.setHtml(it, HtmlHttpImageGetter(dataBindingDetailNews.htmTextContent)) }

    }
}

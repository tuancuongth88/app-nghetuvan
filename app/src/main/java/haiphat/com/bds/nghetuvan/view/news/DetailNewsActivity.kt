package haiphat.com.bds.nghetuvan.view.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.AppBarLayout
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailNewsBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.DetailNewsViewModel

class DetailNewsActivity : BaseActivity() {

    private lateinit var dataBindingDetailNews : ActivityDetailNewsBinding
    private var detailNewsViewMode = DetailNewsViewModel()
    override fun getContentView(): View {
        dataBindingDetailNews = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_news, null, false)
        setSupportActionBar(dataBindingDetailNews.toolbar)
        dataBindingDetailNews.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBar, verticalOffset ->
            if (verticalOffset == 0) {
                dataBindingDetailNews.tvTitle.visibility = View.GONE
            } else if (Math.abs(verticalOffset) >= appBar.totalScrollRange) {
                dataBindingDetailNews.tvNameCourse.visibility = View.GONE
                dataBindingDetailNews.tvTitle.visibility = View.VISIBLE
            } else {
                dataBindingDetailNews.tvTitle.visibility = View.GONE
                dataBindingDetailNews.tvNameCourse.visibility = View.VISIBLE
            }
        })
        return dataBindingDetailNews.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        getDetailNews()
    }

    private fun getDetailNews(){
        ShowLoading.show(this)
        detailNewsViewMode.getDetailNews(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
                dataBindingDetailNews.tvTitle.text = it.name
                dataBindingDetailNews.tvNameCourse.text = it.name
            }, 1000)

        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this@DetailNewsActivity, message = getString(R.string.text_error))
        })
    }


}

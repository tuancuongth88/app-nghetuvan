package haiphat.com.bds.nghetuvan.view.partner

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.AppBarLayout
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityPartnerDetailBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.DetailNewsViewModel
import haiphat.com.bds.nghetuvan.viewmodel.partner.DetailPartnerViewModel

class PartnerDetailActivity : BaseActivity() {

    private lateinit var dataBindingDetailPartner : ActivityPartnerDetailBinding
    private var detailNewsViewMode = DetailPartnerViewModel()
    
    override fun getContentView(): View {
        dataBindingDetailPartner = DataBindingUtil.inflate(layoutInflater, R.layout.activity_partner_detail, null, false)
        setSupportActionBar(dataBindingDetailPartner.toolbar)
        dataBindingDetailPartner.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBar, verticalOffset ->
            if (verticalOffset == 0) {
                dataBindingDetailPartner.tvTitle.visibility = View.GONE
            } else if (Math.abs(verticalOffset) >= appBar.totalScrollRange) {
                dataBindingDetailPartner.tvNameCourse.visibility = View.GONE
                dataBindingDetailPartner.tvTitle.visibility = View.VISIBLE
            } else {
                dataBindingDetailPartner.tvTitle.visibility = View.GONE
                dataBindingDetailPartner.tvNameCourse.visibility = View.VISIBLE
            }
        })
        return dataBindingDetailPartner.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        getDetailPartner()
    }

    private fun getDetailPartner(){
        ShowLoading.show(this)
        detailNewsViewMode.getDetailPartner(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
                dataBindingDetailPartner.tvTitle.text = it.name
            }, 1000)

        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this@PartnerDetailActivity, message = getString(R.string.text_error))
        })
    }

}

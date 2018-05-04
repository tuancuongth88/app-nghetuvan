package haiphat.com.bds.nghetuvan.view.partner

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityPartnerDetailBinding
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.view.BaseActivity
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

class PartnerDetailActivity : BaseActivity() {

    private lateinit var dataBindingDetailPartner: ActivityPartnerDetailBinding

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
        dataBindingDetailPartner.rippleBack.setOnRippleCompleteListener {
            onBackPressed()
        }
        dataBindingDetailPartner.rippleSetting.setOnRippleCompleteListener {
            CommonUtil.shareAppLinkViaFacebook(this, "https://www.facebook.com/dacsanamthuccaobang/?ref=all_category_pyml_rhc")

        }
        return dataBindingDetailPartner.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        var bundle = intent.extras
        var partnerResponse = GsonUtil.fromJson(bundle.getString(IntentActionKeys.KEY_DETAIL_NEWS), PartnerResponse::class.java)
        dataBindingDetailPartner.tvTitle.text = partnerResponse?.name
        dataBindingDetailPartner.imCovert.fromUrl(partnerResponse?.image_url, placeHolder = R.drawable.ic_defaul_bg_my_course)
        dataBindingDetailPartner.tvNameCourse.text = partnerResponse?.name
        partnerResponse?.detail?.let { dataBindingDetailPartner.htmTextContent.setHtml(it, HtmlHttpImageGetter(dataBindingDetailPartner.htmTextContent)) }
    }

}

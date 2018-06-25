package haiphat.com.bds.nghetuvan.view.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.home.SectionsPagerHomeAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailHomeBinding
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.view.BaseActivity

class DetailHomeActivity : BaseActivity() {
    private lateinit var dataBindingDetailHome : ActivityDetailHomeBinding
    override fun getContentView(): View {
        dataBindingDetailHome = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_home, null, false)
        setSupportActionBar(dataBindingDetailHome.toolbar)

        dataBindingDetailHome.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBar, verticalOffset ->
            when (verticalOffset) {
                0 -> {
                    dataBindingDetailHome.tvTitle.visibility = View.GONE
                }else -> {
                    if (Math.abs(verticalOffset) >= appBar.totalScrollRange) {
                        dataBindingDetailHome.tvTitle.visibility = View.VISIBLE
                    } else {
                        dataBindingDetailHome.tvTitle.visibility = View.GONE
                    }
                }
            }
        })

        dataBindingDetailHome.rippleBack.setOnRippleCompleteListener {
            onBackPressed()
        }
        dataBindingDetailHome.rippleSetting.setOnRippleCompleteListener {
            CommonUtil.shareAppLinkViaFacebook(this,"https://developers.facebook.com")
        }

        return dataBindingDetailHome.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        val sectionsPagerAdapter = SectionsPagerHomeAdapter(supportFragmentManager)
        dataBindingDetailHome.container.adapter = sectionsPagerAdapter
        dataBindingDetailHome.tabs.setupWithViewPager(dataBindingDetailHome.container)
        dataBindingDetailHome.tabs.setTabTextColors(ContextCompat.getColor(this, R.color.colorWhite), ContextCompat.getColor(this, R.color.colorWhite))

    }
}

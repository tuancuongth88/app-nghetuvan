package haiphat.com.bds.nghetuvan.view.education

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityEducationDetailBinding
import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.view.fragment.education.InfoEducationFragment
import haiphat.com.bds.nghetuvan.view.fragment.education.RegisterEducationFragment

class EducationDetailActivity : BaseActivity() {

    private lateinit var dataBindingEducationDetail : ActivityEducationDetailBinding

    override fun getContentView(): View {
        dataBindingEducationDetail = DataBindingUtil.inflate(layoutInflater, R.layout.activity_education_detail, null, false)
        dataBindingEducationDetail.rippleBack.setOnRippleCompleteListener {
            onBackPressed()
        }
        dataBindingEducationDetail.rippleSetting.setOnRippleCompleteListener {
            CommonUtil.shareAppLinkViaFacebook(this,"https://developers.facebook.com")
        }
        return dataBindingEducationDetail.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        var bundle = intent.extras
        var education = GsonUtil.fromJson(bundle.getString(IntentActionKeys.KEY_ITEM_EDUCATION), EducationResponse::class.java)
        initView(education)
    }

    private fun initView(educationResponse: EducationResponse?){
        val sectionsPagerAdapter = SectionsPagerEducationAdapter(supportFragmentManager, educationResponse)
        dataBindingEducationDetail.container.adapter = sectionsPagerAdapter
        dataBindingEducationDetail.tabs.setupWithViewPager(dataBindingEducationDetail.container)
        dataBindingEducationDetail.tabs.setTabTextColors(ContextCompat.getColor(this, R.color.colorWhite), ContextCompat.getColor(this, R.color.colorWhite))

    }

    inner class SectionsPagerEducationAdapter(fm: FragmentManager, educationResponse: EducationResponse?) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> {
                    fragment = InfoEducationFragment()
                }
                1 -> {
                    fragment = RegisterEducationFragment()
                }
            }
            return fragment ?: InfoEducationFragment()
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return BaseApplication.context.getString(R.string.text_tab_news_info)
                1 -> return BaseApplication.context.getString(R.string.text_tab_education_register)
            }
            return null
        }
    }


}

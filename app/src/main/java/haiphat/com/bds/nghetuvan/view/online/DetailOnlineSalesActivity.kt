package haiphat.com.bds.nghetuvan.view.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.online.SectionsPagerDetailOnlineSalesAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailOnlineSalesBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity

class DetailOnlineSalesActivity : BaseActivity() {
    
    private lateinit var dataBindingDetailOnlineSales : ActivityDetailOnlineSalesBinding
    override fun getContentView(): View {
        dataBindingDetailOnlineSales = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_online_sales, null, false)
        setSupportActionBar(dataBindingDetailOnlineSales.toolbar)

        return dataBindingDetailOnlineSales.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
        val sectionsPagerAdapter = SectionsPagerDetailOnlineSalesAdapter(supportFragmentManager)
        dataBindingDetailOnlineSales.container.adapter = sectionsPagerAdapter
        dataBindingDetailOnlineSales.tabs.setupWithViewPager(dataBindingDetailOnlineSales.container)
        dataBindingDetailOnlineSales.tabs.setTabTextColors(ContextCompat.getColor(this, R.color.colorWhite), ContextCompat.getColor(this, R.color.colorWhite))

    }
    
    
}

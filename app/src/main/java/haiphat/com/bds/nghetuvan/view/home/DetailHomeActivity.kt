package haiphat.com.bds.nghetuvan.view.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityDetailHomeBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity

class DetailHomeActivity : BaseActivity() {
    private lateinit var dataBindingDetailHome : ActivityDetailHomeBinding
    override fun getContentView(): View {
        dataBindingDetailHome = DataBindingUtil.inflate(layoutInflater, R.layout.activity_detail_home, null, false)
        return dataBindingDetailHome.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

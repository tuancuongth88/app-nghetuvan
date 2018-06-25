package haiphat.com.bds.nghetuvan.view.home

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.home.ShowListHomeAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityShowListHomeBinding
import haiphat.com.bds.nghetuvan.models.home.HomePageResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.home.ShowListViewModel

class ShowListHomeActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var dataBingShowListHome: ActivityShowListHomeBinding
    var showListViewModel = ShowListViewModel()

    override fun getContentView(): View {
        dataBingShowListHome = DataBindingUtil.inflate(layoutInflater, R.layout.activity_show_list_home, null, false)
        dataBingShowListHome.swipeRefreshLayout.setOnRefreshListener(this)
        dataBingShowListHome.swipeRefreshLayout.isRefreshing = true
        getItem()
        return dataBingShowListHome.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle("Danh sach")
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
    }

    private fun initAdapter(list: ArrayList<HomePageResponse>) {
        var recyclerView = dataBingShowListHome.rvShowListHome
        var adapter = ShowListHomeAdapter(list, onClick = {
            var intent = Intent(this@ShowListHomeActivity, DetailHomeActivity::class.java)
            startActivity(intent)
        })
        recyclerView.layoutManager = LinearLayoutManager(this@ShowListHomeActivity)
        recyclerView.adapter = adapter
    }

    private fun getItem() {
        showListViewModel.getItem(onSuccess = {
            initAdapter(it)
            dataBingShowListHome.swipeRefreshLayout.isRefreshing = false
        }, onFailed = {
            ShowAlert.fail(pContext = this, message = it)
            dataBingShowListHome.swipeRefreshLayout.isRefreshing = false
        })
    }

    override fun onRefresh() {
        dataBingShowListHome.swipeRefreshLayout.isRefreshing = true
        getItem()
    }
}

package haiphat.com.bds.nghetuvan.view.profile

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.partner.PartnerAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityHistoryTransactionBinding
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.view.partner.PartnerDetailActivity
import haiphat.com.bds.nghetuvan.viewmodel.partner.PartnerViewModel

class HistoryTransactionsActivity : BaseActivity() {

    private lateinit var dataBindingPartner : ActivityHistoryTransactionBinding
    private var partnerViewModel = PartnerViewModel()

    override fun getContentView(): View {
        dataBindingPartner = DataBindingUtil.inflate(layoutInflater, R.layout.activity_history_transaction, null, false)
        getItemPartner()
        return dataBindingPartner.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle(getString(R.string.title_screen_partner))
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
    }

    private fun initPartnerAdapter(list : ArrayList<PartnerResponse>?){
        val recyclerView = dataBindingPartner.rvPartner
        val adapter = PartnerAdapter(list, onClick = {
            startActivity(Intent(this@HistoryTransactionsActivity, PartnerDetailActivity::class.java))
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun getItemPartner(){
        ShowLoading.show(this)
        partnerViewModel.getItemPartner(onSuccess = {
            Handler(Looper.getMainLooper()).postDelayed({
                ShowLoading.dismiss()
                initPartnerAdapter(it)
            }, 1000)
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this@HistoryTransactionsActivity, message = getString(R.string.text_error))
        })
    }
}

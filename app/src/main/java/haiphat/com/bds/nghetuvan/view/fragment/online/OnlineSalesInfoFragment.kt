package haiphat.com.bds.nghetuvan.view.fragment.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.online.InfoOnlineSalesAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentInfoOnlineSalesBinding
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.HomeInfoViewModel
import haiphat.com.bds.nghetuvan.viewmodel.onlineSales.DetailOnlineSalesViewModel

class OnlineSalesInfoFragment : BaseFragment() {
    private lateinit var dataBindingFragmentInfoOnlineSales: FragmentInfoOnlineSalesBinding
    private var detailInfoOnlineSalesViewModel = DetailOnlineSalesViewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentInfoOnlineSales = DataBindingUtil.inflate(inflater, R.layout.fragment_info_online_sales, container, false)
        getInfoOnlineSales()
        return dataBindingFragmentInfoOnlineSales.root
    }

    private fun initAdapter(list : ArrayList<TypeTableOfGoodsResponse>){
        val recyclerView = dataBindingFragmentInfoOnlineSales.rvInfoOnlineSales
        val adapter = InfoOnlineSalesAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun getInfoOnlineSales(){
        ShowLoading.show(context)
        detailInfoOnlineSalesViewModel.getInfoOnlineSales(onSuccess = {
            initAdapter(it)
            ShowLoading.dismiss()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }
}
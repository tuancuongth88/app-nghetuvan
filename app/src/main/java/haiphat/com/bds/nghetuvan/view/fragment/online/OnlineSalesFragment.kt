package haiphat.com.bds.nghetuvan.view.fragment.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentOnlineSalesBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.viewmodel.onlineSales.OnlineSalesViewModel

class OnlineSalesFragment : BaseFragment(){

    private lateinit var dataBindingFragmentOnlineSales: FragmentOnlineSalesBinding
    private var onlineSalesViewModel = OnlineSalesViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentOnlineSales = DataBindingUtil.inflate(inflater, R.layout.fragment_online_sales, container, false)
        context?.let{
            (activity as HomeActivity).setBackgroundColor(ContextCompat.getColor(it, R.color.colorPrimary))
        }
        getTypeTable()
        return dataBindingFragmentOnlineSales.root
    }

    private fun getTypeTable(){
        ShowLoading.show(context)
        onlineSalesViewModel.getTypeTableOfGoods(onSuccess = {
            ShowLoading.dismiss()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }



    private fun getTableGoods(){
        ShowLoading.show(context)
        onlineSalesViewModel.getTableOfGoods(onSuccess = {
            ShowLoading.dismiss()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }
}
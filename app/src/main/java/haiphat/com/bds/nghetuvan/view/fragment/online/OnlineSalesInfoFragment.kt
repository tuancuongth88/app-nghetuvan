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
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.home.HomeInfoViewModel

class OnlineSalesInfoFragment : BaseFragment() {
    private lateinit var dataBindingFragmentInfoOnlineSales: FragmentInfoOnlineSalesBinding
    private var homeInfoViewModel = HomeInfoViewModel()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentInfoOnlineSales = DataBindingUtil.inflate(inflater, R.layout.fragment_info_online_sales, container, false)
        return dataBindingFragmentInfoOnlineSales.root
    }

    private fun initAdapter(list : ArrayList<TypeTableOfGoodsResponse>){
        val recyclerView = dataBindingFragmentInfoOnlineSales.rvInfoOnlineSales
        val adapter = InfoOnlineSalesAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun getInfoOnlineSales(){

    }
}
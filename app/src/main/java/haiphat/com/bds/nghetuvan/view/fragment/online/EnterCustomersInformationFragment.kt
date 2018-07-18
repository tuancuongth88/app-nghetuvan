package haiphat.com.bds.nghetuvan.view.fragment.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.online.InfoOnlineSalesAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentEnterCustomersInformationBinding
import haiphat.com.bds.nghetuvan.databinding.FragmentInfoOnlineSalesBinding
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.onlineSales.DetailOnlineSalesViewModel

class EnterCustomersInformationFragment : BaseFragment() {
    private lateinit var dataBindingFragmentEnterCustomersInformation: FragmentEnterCustomersInformationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentEnterCustomersInformation = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_customers_information, container, false)
        return dataBindingFragmentEnterCustomersInformation.root
    }
}
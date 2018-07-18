package haiphat.com.bds.nghetuvan.view.fragment.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentEnterCustomersInformationBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

class EnterCustomerInformationFragment : BaseFragment() {
    private lateinit var dataBindingFragmentEnterCustomerInformation: FragmentEnterCustomersInformationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentEnterCustomerInformation = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_customers_information, container, false)
        return dataBindingFragmentEnterCustomerInformation.root
    }
}
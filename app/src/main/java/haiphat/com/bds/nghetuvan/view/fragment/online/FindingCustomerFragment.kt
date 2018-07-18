package haiphat.com.bds.nghetuvan.view.fragment.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentFindingCustomersBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

class FindingCustomerFragment : BaseFragment() {
    private lateinit var dataBindingFragmentFindingCustomer: FragmentFindingCustomersBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentFindingCustomer = DataBindingUtil.inflate(inflater, R.layout.fragment_finding_customers, container, false)
        return dataBindingFragmentFindingCustomer.root
    }


}
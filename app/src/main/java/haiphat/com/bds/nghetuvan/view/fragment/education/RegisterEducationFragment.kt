package haiphat.com.bds.nghetuvan.view.fragment.education

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentRegisterEducationBinding
import haiphat.com.bds.nghetuvan.view.BaseFragment

class RegisterEducationFragment : BaseFragment(){

    private lateinit var dataBindingFragmentRegisterEducation: FragmentRegisterEducationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentRegisterEducation = DataBindingUtil.inflate(inflater, R.layout.fragment_register_education, container, false)
        return dataBindingFragmentRegisterEducation.root
    }


}
package haiphat.com.bds.nghetuvan.view.fragment.education

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.education.RegisterEducationAdapter
import haiphat.com.bds.nghetuvan.databinding.FragmentRegisterEducationBinding
import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.services.UserServices
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.extensions.toHtml
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.education.EducationDetailActivity
import haiphat.com.bds.nghetuvan.viewmodel.education.EducationDetailViewModel

class RegisterEducationFragment : BaseFragment() {
    private var educationDetailViewModel = EducationDetailViewModel()
    private lateinit var dataBindingFragmentRegisterEducation: FragmentRegisterEducationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentRegisterEducation = DataBindingUtil.inflate(inflater, R.layout.fragment_register_education, container, false)
        initView((activity as EducationDetailActivity).setData())
        dataBindingFragmentRegisterEducation.btnSubmit.setOnClickListener {
            submitForm()
        }
        return dataBindingFragmentRegisterEducation.root
    }

    private fun initView(data: EducationResponse?) {
        dataBindingFragmentRegisterEducation.tvTitle.text = data?.name
        dataBindingFragmentRegisterEducation.tvDescription.text = data?.description?.toHtml()
        UserServices?.userInfo?.let {
            dataBindingFragmentRegisterEducation.edEmail.setText(it.email)
            dataBindingFragmentRegisterEducation.edFullName.setText(it.fullname)
            dataBindingFragmentRegisterEducation.edPhone.setText(it.phone)
        }
    }

    private fun submitForm() {
        educationDetailViewModel.id = (activity as EducationDetailActivity).setData()?.id.toString()
        educationDetailViewModel.email = dataBindingFragmentRegisterEducation.edEmail.text.toString()
        educationDetailViewModel.fullName = dataBindingFragmentRegisterEducation.edFullName.text.toString()
        educationDetailViewModel.phone = dataBindingFragmentRegisterEducation.edPhone.text.toString()
        educationDetailViewModel.submitFormEducation(onSuccess = {
            ShowAlert.fail(pContext = activity, dialogTitle = getString(R.string.alert_title_inform), message = it)
        }, onFailed = {
            ShowAlert.fail(pContext = activity, message = it)
        })
    }


}
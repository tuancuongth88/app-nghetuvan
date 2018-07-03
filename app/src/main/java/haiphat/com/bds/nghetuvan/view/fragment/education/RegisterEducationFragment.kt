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
import haiphat.com.bds.nghetuvan.models.education.ItemEducationResponse
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.education.EducationDetailViewModel

class RegisterEducationFragment : BaseFragment(){
    private var educationDetailViewModel = EducationDetailViewModel()
    private lateinit var dataBindingFragmentRegisterEducation: FragmentRegisterEducationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentRegisterEducation = DataBindingUtil.inflate(inflater, R.layout.fragment_register_education, container, false)
        getFormRegisterEducation()
        dataBindingFragmentRegisterEducation.btnSubmit.setOnClickListener {
            submitForm()
        }
        return dataBindingFragmentRegisterEducation.root
    }

    private fun setData(data : ItemEducationResponse){
        dataBindingFragmentRegisterEducation.tvTitle.text = data.title
        dataBindingFragmentRegisterEducation.tvDescription.text = data.description
        var recyclerView = dataBindingFragmentRegisterEducation.rvWhoAreYou
        var adapter = RegisterEducationAdapter(data?.item, onClick = {
        })
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun submitForm(){
        educationDetailViewModel.submitFormEducation(onSuccess = {
            ShowAlert.fail(pContext = activity, dialogTitle = getString(R.string.alert_title_inform),message = getString(R.string.alert_title_success))
        }, onFailed = {
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }

    private fun getFormRegisterEducation(){
        EducationDetailViewModel().getFormRegisterEducation(onSuccess = {
           setData(it)
        }, onFailed = {
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }
}
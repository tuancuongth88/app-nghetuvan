package haiphat.com.bds.nghetuvan.view.fragment.education

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentInfoEducationBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.viewmodel.education.EducationDetailViewModel
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter

class InfoEducationFragment : BaseFragment(){

    private lateinit var dataBindingFragmentInfoEducation: FragmentInfoEducationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentInfoEducation = DataBindingUtil.inflate(inflater, R.layout.fragment_info_education, container, false)
        getInfoEducation()
        return dataBindingFragmentInfoEducation.root
    }


    private fun getInfoEducation(){
        EducationDetailViewModel().getInfoEducation(onSuccess = {
            dataBindingFragmentInfoEducation.htmTextInfo.setHtml(it, HtmlHttpImageGetter(dataBindingFragmentInfoEducation.htmTextInfo))
        }, onFailed = {
            ShowAlert.fail(pContext = activity, message = getString(R.string.text_error))
        })
    }
}
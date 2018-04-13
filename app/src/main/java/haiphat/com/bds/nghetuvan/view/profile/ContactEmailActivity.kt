package haiphat.com.bds.nghetuvan.view.profile

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityContactEmailBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.profiles.ContactEmailViewModel

class ContactEmailActivity : BaseActivity() {

    private lateinit var dataBindingContactEmail: ActivityContactEmailBinding
    private var contactEmailViewModel = ContactEmailViewModel()


    override fun getContentView(): View {
        dataBindingContactEmail = DataBindingUtil.inflate(layoutInflater, R.layout.activity_contact_email, null, false)
        dataBindingContactEmail.rippleSave.setOnRippleCompleteListener {
            sendContact()
        }
        dataBindingContactEmail.rippleBack.setOnRippleCompleteListener { this.onBackPressed() }
        return dataBindingContactEmail.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderVisibility(View.GONE)
    }

    private fun sendContact() {
        if (Validator().validate(dataBindingContactEmail)) {
            ShowLoading.show(this@ContactEmailActivity)
            contactEmailViewModel.email = dataBindingContactEmail.telEmail.text.toString()
            contactEmailViewModel.phone = dataBindingContactEmail.telPhone.text.toString()
            contactEmailViewModel.content = dataBindingContactEmail.telContent.text.toString()
            contactEmailViewModel.sendContact(onSuccess = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this@ContactEmailActivity, dialogTitle = getString(R.string.alert_title_inform), message = getString(R.string.contact_email_successfull))
            }, onFailed = {
                ShowLoading.dismiss()
                ShowAlert.fail(pContext = this@ContactEmailActivity, message = getString(R.string.text_error))
            })
        }
    }

}

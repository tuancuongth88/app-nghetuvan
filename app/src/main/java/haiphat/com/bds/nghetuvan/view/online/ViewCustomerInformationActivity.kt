package haiphat.com.bds.nghetuvan.view.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Html
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityViewCustomerInformationBinding
import haiphat.com.bds.nghetuvan.models.online.PayResponse
import haiphat.com.bds.nghetuvan.models.online.convertPayType
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.utils.extensions.toHtml
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.onlineSales.PayViewModel

class ViewCustomerInformationActivity : BaseActivity() {

    private lateinit var dataBindingViewCustomerInformation: ActivityViewCustomerInformationBinding
    private var payViewModel = PayViewModel()


    override fun getContentView(): View {
        dataBindingViewCustomerInformation = DataBindingUtil.inflate(layoutInflater, R.layout.activity_view_customer_information, null, false)
        dataBindingViewCustomerInformation.rippleBack.setOnRippleCompleteListener {
            onBackPressed()
        }
        dataBindingViewCustomerInformation.rippleContinue.setOnRippleCompleteListener {
            submit()
        }
        return dataBindingViewCustomerInformation.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
        initView(payViewModel.mockDataSendRequire())
    }

    private fun initView(payResponse: PayResponse) {
        dataBindingViewCustomerInformation.tvFullName.text = getString(R.string.text_pay_full_name, payResponse.fullName).toHtml()
        dataBindingViewCustomerInformation.tvAddress.text = getString(R.string.text_pay_address,payResponse.address).toHtml()
        dataBindingViewCustomerInformation.tvCMTND.text = getString(R.string.text_pay_cmtnd,payResponse.idNumber).toHtml()
        dataBindingViewCustomerInformation.tvEmail.text = getString(R.string.text_pay_email,payResponse.email).toHtml()
        dataBindingViewCustomerInformation.tvPrice.text = getString(R.string.text_pay_price,payResponse.price).toHtml()
        dataBindingViewCustomerInformation.tvTypePay.text = payResponse.type?.convertPayType()
    }

    private fun submit() {
        ShowLoading.show(this@ViewCustomerInformationActivity)
        payViewModel.sendRequire(onSuccess = {
            var it = "Giao dịch của bạn đã được tạo thành công! Sau khi có xác nhận từ hệ thống, hãy kiểm tra email và làm theo hướng dẫn để hoàn thành giao dịch"
            ShowAlert.confirm(pContext = this@ViewCustomerInformationActivity, message = it)
            ShowLoading.dismiss()
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this@ViewCustomerInformationActivity, message = it)
        })
    }
}

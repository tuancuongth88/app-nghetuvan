package haiphat.com.bds.nghetuvan.view.online

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityViewCustomerInformationBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity

class ViewCustomerInformationActivity : BaseActivity() {

    private lateinit var dataBindingViewCustomerInformation : ActivityViewCustomerInformationBinding

    override fun getContentView(): View {
        dataBindingViewCustomerInformation = DataBindingUtil.inflate(layoutInflater, R.layout.activity_view_customer_information, null, false)
        return dataBindingViewCustomerInformation.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
    }
}

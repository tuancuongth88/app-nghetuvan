package haiphat.com.bds.nghetuvan.view.project

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityProjectPaymentBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity

class ProjectPaymentActivity : BaseActivity() {
    private lateinit var dataBingProjectPayment : ActivityProjectPaymentBinding

    override fun getContentView(): View {
        dataBingProjectPayment = DataBindingUtil.inflate(layoutInflater, R.layout.activity_project_payment, null, false)
        return dataBingProjectPayment.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        setHeaderTitle("Tính lãi suất vay dự án")
    }
}

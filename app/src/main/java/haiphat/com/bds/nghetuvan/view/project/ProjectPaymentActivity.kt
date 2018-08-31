package haiphat.com.bds.nghetuvan.view.project

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.Window
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityProjectPaymentBinding
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.DialogChangeAvatar
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.project.ProjectPaymentViewModel


class ProjectPaymentActivity : BaseActivity() {
    private lateinit var dataBingProjectPayment: ActivityProjectPaymentBinding


    override fun getContentView(): View {
        dataBingProjectPayment = DataBindingUtil.inflate(layoutInflater, R.layout.activity_project_payment, null, false)

        dataBingProjectPayment.lnDisbursementDate.setOnClickListener {
            CommonUtil.showDatePickerDialog(this@ProjectPaymentActivity, dataBingProjectPayment.lnDisbursementDate)
        }

        dataBingProjectPayment.edType.setOnClickListener {
            var dialogChangeImage = DialogChangeAvatar(this, onSelectedCamera = {
                dataBingProjectPayment.edType.setText("Dư nợ giảm dần")

            }, onSelectedGallery = {
                dataBingProjectPayment.edType.setText("Dư Ban đầu")
            })
            dialogChangeImage.setCanceledOnTouchOutside(false)
            dialogChangeImage.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogChangeImage.show()
        }
        dataBingProjectPayment.switchView.setOnCheckedChangeListener { compoundButton, isChecked ->
            dataBingProjectPayment.edTimeGrace.isEnabled = isChecked
        }

        dataBingProjectPayment.ripRegister.setOnRippleCompleteListener {
            ProjectPaymentViewModel().getTableInterest()
        }
        return dataBingProjectPayment.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        setHeaderTitle("Tính lãi suất vay dự án")
    }
}





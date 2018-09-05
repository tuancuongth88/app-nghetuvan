package haiphat.com.bds.nghetuvan.view.project

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.Window
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityProjectPaymentBinding
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.DialogChangeAvatar
import haiphat.com.bds.nghetuvan.utils.extensions.formatCurrency
import haiphat.com.bds.nghetuvan.utils.validation.Validator
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.project.ProjectPaymentViewModel


class ProjectPaymentActivity : BaseActivity() {
    private lateinit var dataBingProjectPayment: ActivityProjectPaymentBinding
    private var projectPaymentViewModel = ProjectPaymentViewModel()

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
            if (Validator().validate(dataBingProjectPayment)) {
                val intent = Intent(this@ProjectPaymentActivity, InterestRateSpreadsheetActivity::class.java)
                intent.putExtra("TONG_TIEN", dataBingProjectPayment.edLoanNumber.text.toString())
                intent.putExtra("THOI_GIAN_VAY", dataBingProjectPayment.edBorrowedTime.text.toString())
                intent.putExtra("NGAY_GIAI_NGAN", dataBingProjectPayment.lnDisbursementDate.text.toString())
                intent.putExtra("LAI_SUAT", dataBingProjectPayment.ed1.text.toString())
                if (dataBingProjectPayment.edTimeGrace.text.isEmpty()){
                    intent.putExtra("AN_HAN", "0")
                }else {
                    intent.putExtra("AN_HAN", dataBingProjectPayment.edTimeGrace.text.toString())
                }
//                intent.putExtra("LOAI_VAY", dataBingProjectPayment.edType.text.toString())
                startActivity(intent)
            }
        }
        return dataBingProjectPayment.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        setHeaderTitle("Tính lãi suất vay dự án")

    }
}





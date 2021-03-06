package haiphat.com.bds.nghetuvan.view.project

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.Window
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityProjectPaymentBinding
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.DialogChangeAvatar
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
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
                dataBingProjectPayment.edType.setText("1")

            }, onSelectedGallery = {
                dataBingProjectPayment.edType.setText("2")
            })
            dialogChangeImage.setCanceledOnTouchOutside(false)
            dialogChangeImage.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogChangeImage.show()
        }
        dataBingProjectPayment.switchView.setOnCheckedChangeListener { compoundButton, isChecked ->
            dataBingProjectPayment.edTimeGrace.isEnabled = isChecked
        }

        dataBingProjectPayment.ripRegister.setOnRippleCompleteListener {
            if (!validate()) {
                val intent = Intent(this@ProjectPaymentActivity, InterestRateSpreadsheetActivity::class.java)
                intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_AMOUNT, dataBingProjectPayment.edLoanNumber.text.toString())
                intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_BORROWED_TIME, dataBingProjectPayment.edBorrowedTime.text.toString())
                intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_DISBURSEMENT_DATE, dataBingProjectPayment.lnDisbursementDate.text.toString())
                intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_INTEREST_RATE, dataBingProjectPayment.ed1.text.toString())
                if (dataBingProjectPayment.edTimeGrace.text.isEmpty()){
                    intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_LIMITATION, "0")
                }else {
                    intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_LIMITATION, dataBingProjectPayment.edTimeGrace.text.toString())
                }
                intent.putExtra(IntentActionKeys.KEY_INPUT_TOTAL_TYPE, dataBingProjectPayment.edType.text.toString())
                startActivity(intent)
            }else{
                ShowAlert.fail(this, dialogTitle = getString(R.string.alert_title_inform), message = "Nhập đầy đủ thông tin")
            }
        }
        return dataBingProjectPayment.root
    }

    private fun validate(): Boolean{
        var isCheck : Boolean = false
        if (dataBingProjectPayment.edLoanNumber.text.isEmpty() || dataBingProjectPayment.edBorrowedTime.text.isEmpty()
                || dataBingProjectPayment.lnDisbursementDate.text.isEmpty()|| dataBingProjectPayment.ed1.text.isEmpty()
        || dataBingProjectPayment.edType.text.isEmpty()){
            isCheck = true
        }
        return isCheck
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        setHeaderTitle("Tính lãi suất vay dự án")

    }
}





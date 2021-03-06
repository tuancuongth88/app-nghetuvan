package haiphat.com.bds.nghetuvan.viewmodel.project

import haiphat.com.bds.nghetuvan.models.project.InterestRateSpreadsheetResponse
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ProjectPaymentViewModel {
    var totalCash: Float = 0f
    var borrowedTime: Int = 0
    var disbursementDate: String = ""
    var gracePeriod: Int = 0
    var interest: Float = 0f
    var type: Int = 0
    var list = ArrayList<InterestRateSpreadsheetResponse>()

    fun getTableInterest() {
        when (gracePeriod) {
            0 -> {
                getTableInterest(borrowedTime, disbursementDate, false)
            }
            else -> {
                var payDay = disbursementDate
                for (i in 1 .. gracePeriod){
                    payDay = addMonth(disbursementDate, i-1)
                    list.add(InterestRateSpreadsheetResponse(payDay = payDay,originalPay = 0f, interest = 0f, total = 0f, rest = totalCash))
                }
                getTableInterest(borrowedTime - gracePeriod, payDay, true)

            }
        }
    }

    private fun getTableInterest(borrowedTime: Int, date: String, isGrace : Boolean): ArrayList<InterestRateSpreadsheetResponse> {
        for (i in 1..borrowedTime) {
            var originalPay = (totalCash / borrowedTime).toFloat()
            var interest = (totalCash /12) * (interest/100)
            var total = originalPay + interest
            var rest = totalCash - (originalPay * i)
            var payDay = if (isGrace) addMonth(date, i) else addMonth(date, i - 1)
            list.add(InterestRateSpreadsheetResponse(payDay = payDay,originalPay = originalPay, interest = interest, total = total, rest = rest))
        }
        return list
    }

    private fun addMonth(date: String, i: Int): String {
        val cal = Calendar.getInstance()
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        cal.time = formatter.parse(date)
        cal.add(Calendar.MONTH, i)
        return formatter.format(cal.time)
    }

}

package haiphat.com.bds.nghetuvan.utils.extensions

import java.text.NumberFormat

fun Float.formatCurrency(): String{
    val fmt = NumberFormat.getNumberInstance()
    return fmt.format(this)
}
package haiphat.com.bds.nghetuvan.utils.extensions

import android.text.Html
import android.text.Spanned
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
fun String.isEmail(): Boolean {
    var emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]"
    return this.matches(emailRegex.toRegex())
}

fun String.formatDate(): String {
    val date = Date()
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return simpleDateFormat.format(date)
}

fun String.convertToDateTime(): String {
    val date = Date()
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy '-' HH:mm a")
    simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return simpleDateFormat.format(date)
}


fun String.formatDateTime(typeDate : String): String {
    val date = Date()
    val simpleDateFormat = SimpleDateFormat(typeDate)
    simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
    return simpleDateFormat.format(date)
}

fun String.toHtml(): Spanned? {
    return Html.fromHtml(this)
}

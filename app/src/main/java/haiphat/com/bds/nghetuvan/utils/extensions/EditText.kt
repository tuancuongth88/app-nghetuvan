package haiphat.com.bds.nghetuvan.utils.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
fun EditText.hideSoftKeyboard(activity: Activity) {
    this.clearFocus()
    this.isCursorVisible = true
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}


fun EditText.showSoftKeyboard(activity: Activity) {
    this.requestFocus()
    this.isCursorVisible = true
    val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
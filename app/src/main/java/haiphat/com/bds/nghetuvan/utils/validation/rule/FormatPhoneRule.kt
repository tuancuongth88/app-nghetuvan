package haiphat.com.bds.nghetuvan.utils.validation.rule

import android.text.TextWatcher
import android.util.Patterns
import android.widget.TextView

/**
 * Created by DEV-01 on 12/27/2017.
 */
class FormatPhoneRule(view: TextView, errorMessage: CharSequence) : BaseRule<TextView>(view, errorMessage), TextWatcher {

    override val isValid: Boolean
        get() {
            return Patterns.PHONE.matcher(view.text).matches()
        }

}
package haiphat.com.bds.nghetuvan.utils.validation.rule

import android.text.TextWatcher
import android.widget.TextView
import haiphat.com.bds.nghetuvan.utils.extensions.isEmail

/**
 * Created by DEV-01 on 12/27/2017.
 */
class FormatEmailRule(view: TextView, errorMessage: CharSequence) : BaseRule<TextView>(view, errorMessage), TextWatcher {

    override val isValid: Boolean
        get() {
            return this.view.text.toString().trim().isEmail()
        }

}

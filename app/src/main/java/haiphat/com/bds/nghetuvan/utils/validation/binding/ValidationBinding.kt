package haiphat.com.bds.nghetuvan.utils.validation.binding

import android.databinding.BindingAdapter
import android.widget.TextView
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.utils.helper.TagViewHelpler
import haiphat.com.bds.nghetuvan.utils.validation.rule.FormatEmailRule
import haiphat.com.bds.nghetuvan.utils.validation.rule.MatchTextRule
import haiphat.com.bds.nghetuvan.utils.validation.rule.RequiredRule

/**
 * Created by DEV-01 on 12/27/2017.
 */
object ValidationBinding {
    @JvmStatic
    @BindingAdapter("validateRequiredErrorMessage")
    fun bindingRequiredField(view: TextView, errorMessage: String) {
        TagViewHelpler().appendValue(R.id.validation, view, RequiredRule(view, errorMessage))
    }

    @JvmStatic
    @BindingAdapter("validateEmailErrorMessage")
    fun bindingEmailFormatField(view: TextView, errorMessage: String) {
        TagViewHelpler().appendValue(R.id.validation, view, FormatEmailRule(view, errorMessage))
    }

    @JvmStatic
    @BindingAdapter("validateComparableView", "validateMatchTextErrorMessage", requireAll = false)
    fun bindingMatchText(view: TextView, comparableView: TextView, errorMessage: String) {
        TagViewHelpler().appendValue(R.id.validation, view, MatchTextRule(view, comparableView, errorMessage))
    }

}
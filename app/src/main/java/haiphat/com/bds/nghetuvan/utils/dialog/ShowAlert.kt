package haiphat.com.bds.nghetuvan.utils.dialog

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import haiphat.com.bds.nghetuvan.R

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ShowAlert {
    companion object {
        fun confirm(pContext: Context?,
                    dialogTitle: String? = null,
                    dialogOk: String? = null,
                    dialogCancel: String? = null,
                    canceledOnTouchOutside: Boolean? = false,
                    message: String?, onClick: (() -> Unit)? = null) {
            pContext?.let {
                MaterialDialog.Builder(pContext)
                        .title(dialogTitle ?: it.getString(R.string.alert_title_confirm))
                        .positiveText(dialogOk ?: it.getString(R.string.text_dialog_ok))
                        .negativeText(dialogCancel ?: it.getString(R.string.text_cancel))
                        .canceledOnTouchOutside(canceledOnTouchOutside == true)
                        .onPositive { _, _ ->  onClick?.let { it.invoke() }  }
                        .content(message ?: "").show()
            }
        }

        fun fail(pContext: Context?,
                 dialogTitle: String? = null,
                 dialogOk: String? = null,
                 canceledOnTouchOutside: Boolean? = false,
                 cancelable: Boolean? = false,
                 message: String? = "", onClick: (() -> Unit)? = null) {
            pContext?.let {
                MaterialDialog.Builder(pContext)
                        .title(dialogTitle ?: it.getString(R.string.alert_title_error))
                        .positiveText(dialogOk ?: it.getString(R.string.text_dialog_ok))
                        .canceledOnTouchOutside(canceledOnTouchOutside == true)
                        .cancelable(cancelable == true)
                        .onPositive { _, _ -> onClick?.let { it.invoke() } }
                        .content(message ?: "").show()
            }
        }
    }
}
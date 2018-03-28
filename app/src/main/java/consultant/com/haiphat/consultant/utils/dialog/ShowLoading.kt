package consultant.com.haiphat.consultant.utils.dialog

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import consultant.com.haiphat.consultant.R

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
object ShowLoading {
    private var materialDialog: MaterialDialog? = null

    fun show(pContext: Context?) {
        if (!(this.materialDialog?.isShowing?:false)){
            pContext?.let {
                materialDialog = MaterialDialog.Builder(it)
                        .content(R.string.text_processing)
                        .progress(true, 0)
                        .canceledOnTouchOutside(false)
                        .cancelable(false)
                        .show()
            }
        }
    }

    fun dismiss() {
        this.materialDialog?.let {
            if (it.isShowing)
                it.dismiss()
        }
    }
}
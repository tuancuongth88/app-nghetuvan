package haiphat.com.bds.nghetuvan.view.profile

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityContactEmailBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

class ContactEmailActivity : BaseActivity() {

    private lateinit var dataBindingContactEmail: ActivityContactEmailBinding
    private var replyNewsCommentViewModel = NewsCommentViewModel()

    override fun getContentView(): View {
        dataBindingContactEmail = DataBindingUtil.inflate(layoutInflater, R.layout.activity_contact_email, null, false)
        dataBindingContactEmail.btnSend.setOnClickListener {
            sendEmail()
        }
        return dataBindingContactEmail.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle(getString(R.string.title_action_bar_contact))
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)

    }

    private fun sendEmail(){
        ShowLoading.show(this@ContactEmailActivity)
        replyNewsCommentViewModel.replyDiscussion(onSuccess = {
            ShowLoading.dismiss()
            Toast.makeText(this@ContactEmailActivity, getString(R.string.discussion_training_course_detail_comment_successfully), Toast.LENGTH_LONG).show()
                finish()
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(this@ContactEmailActivity, message = getString(R.string.text_error))
        })
    }
}

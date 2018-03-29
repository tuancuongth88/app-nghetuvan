package haiphat.com.bds.nghetuvan.view.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityReplyNewsCommentBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

class ReplyNewsCommentActivity : BaseActivity() {

    private lateinit var bindingReplyDiscussion: ActivityReplyNewsCommentBinding
    private var replyNewsCommentViewModel = NewsCommentViewModel()

    override fun getContentView(): View {
        bindingReplyDiscussion = DataBindingUtil.inflate(layoutInflater, R.layout.activity_reply_news_comment, null, false)
        return bindingReplyDiscussion.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle(getString(R.string.title_screen_reply_create_discussion))
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
    }

    private fun replyDiscussion(){
        ShowLoading.show(this@ReplyNewsCommentActivity)
        replyNewsCommentViewModel.content = bindingReplyDiscussion.edContent.text.toString()
        replyNewsCommentViewModel.replyDiscussion(onSuccess = {
            ShowLoading.dismiss()
            Toast.makeText(this@ReplyNewsCommentActivity, getString(R.string.discussion_training_course_detail_comment_successfully), Toast.LENGTH_LONG).show()
//                setResult(IntentActionKeys.RELOAD_DATA)
                finish()
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(this@ReplyNewsCommentActivity, message = getString(R.string.text_error))
        })
    }
}

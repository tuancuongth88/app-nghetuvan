package haiphat.com.bds.nghetuvan.view.news

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.ActivityPostCommentBinding
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.news.NewsCommentViewModel

class PostCommentActivity : BaseActivity() {

    private lateinit var dataBindingPostComment: ActivityPostCommentBinding
    private var newsCommentViewModel = NewsCommentViewModel()

    override fun getContentView(): View {
        dataBindingPostComment = DataBindingUtil.inflate(layoutInflater, R.layout.activity_post_comment, null, false)
        return dataBindingPostComment.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderTitle(getString(R.string.text_tab_news_comment))
        baseActivityBinding.tvTitle.setTextColor(ContextCompat.getColor(this, R.color.textLabel))
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite))
        baseActivityBinding.imgBack.setImageResource(R.drawable.ic_back_b)
        var bundel = intent.extras
        newsCommentViewModel.newsId = bundel.getString(IntentActionKeys.KEY_NEWS_ID)
        baseActivityBinding.rippleRight.visibility = View.VISIBLE
        baseActivityBinding.rippleRight.setOnRippleCompleteListener {
            postComment()
        }
    }


    private fun postComment() {
        ShowLoading.show(this@PostCommentActivity)
        newsCommentViewModel.content = dataBindingPostComment.edContent.text.toString()
        newsCommentViewModel.postComment(onSuccess = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this, dialogTitle = getString(R.string.alert_title_inform), message = it, onClick = {
                setResult(IntentActionKeys.KEY_RELOAD_DATA)
                finish()
            })
        }, onFailed = {
            ShowLoading.dismiss()
            ShowAlert.fail(pContext = this, message = it)
        })
    }

}

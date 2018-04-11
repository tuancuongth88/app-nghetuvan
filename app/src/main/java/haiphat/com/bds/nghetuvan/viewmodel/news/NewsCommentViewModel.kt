package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.news.ListCommentNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.news.NewsApi

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class NewsCommentViewModel {
    var content: String? = null
    var id: String? = null

    fun getListComment(onSuccess: (ArrayList<NewsCommentResponse>) -> Unit, onFailed: (String?) -> Unit) {
        NewsApi().getListComment(id, onResponse = {
            var dataResponse = GsonUtil.fromJson(it.responseContent, ListCommentNewsResponse::class.java)
            it?.isSuccess()?.let {
                dataResponse?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        })
    }
}
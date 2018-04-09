package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.models.news.ListCategory
import haiphat.com.bds.nghetuvan.models.news.ListNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.news.NewsApi

class NewsViewModel {
    var id: String? = null
    fun getItemNews(onSuccess: (ArrayList<NewsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        NewsApi().getItemNews(id, onResponse = {
            var item = GsonUtil.fromJson(it.responseContent, ListNewsResponse::class.java)
            it.isSuccess()?.let {
                item?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        })
    }

    fun getCategoryNews(onSuccess: (ArrayList<CategoryNewsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        NewsApi().getCategory {
            var itemCategoryNews = GsonUtil.fromJson(it.responseContent, ListCategory::class.java)
            it?.isSuccess()?.let {
                itemCategoryNews?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        }
    }

}
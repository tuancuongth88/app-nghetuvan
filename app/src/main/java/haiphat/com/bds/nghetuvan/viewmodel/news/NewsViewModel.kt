package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.models.news.ListCategory
import haiphat.com.bds.nghetuvan.models.news.ListNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.news.NewsApi
import java.util.*

class NewsViewModel {
    var id: String? = null
    var page: Int? = 1

    fun getItemNews(onSuccess: (ArrayList<NewsResponse>?) -> Unit, onFailed: (String?) -> Unit) {
        NewsApi().getItemNews(id, page.toString(), onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ListNewsResponse::class.java)

            if (it.isSuccess()){
                onSuccess(response?.data)
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }

    fun getCategoryNews(onSuccess: (ArrayList<CategoryNewsResponse>?) -> Unit, onFailed: (String?) -> Unit) {
        NewsApi().getCategory {
            var response = GsonUtil.fromJson(it.responseContent, ListCategory::class.java)
            if (it.isSuccess()) {
                onSuccess(response?.data)
            } else {
                onFailed(it.getErrorMessage())
            }
        }
    }

}
package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.news.NewsApi

class CategoryNewsViewModel {
    fun getItemNews(onSuccess : (ArrayList<CategoryNewsResponse>) ->Unit, onFailed : (String?) -> Unit) {
        NewsApi().getCategory {
            val categoryNewResponse = GsonUtil.fromJson(it.responseContent, BaseResponse<CategoryNewsResponse>()::class.java)
            if (it.isSuccess()?: false){
                categoryNewResponse?.data?.let { it1 -> onSuccess(it1) }
            }else{
                onFailed(it.getErrorMessage())
            }

        }

    }

}
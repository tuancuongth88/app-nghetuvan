package haiphat.com.bds.nghetuvan.viewmodel.onlineSales

import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.models.news.ListCategory
import haiphat.com.bds.nghetuvan.models.news.ListNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.onlineSales.OnlineSalesApi

class OnlineSalesViewModel {
    var categoryId: Int? = 0
    var building: Int? = 0

    fun getTableOfGoods(onSuccess: (ArrayList<NewsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        OnlineSalesApi().getTableOfGoods(categoryId.toString(), building.toString(), onResponse = {
            var item = GsonUtil.fromJson(it.responseContent, ListNewsResponse::class.java)
            it.status?.let {
                item?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        })
    }

    fun getTypeTableOfGoods(onSuccess: (ArrayList<CategoryNewsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        OnlineSalesApi().getTypeTableOfGoods {
            var itemCategoryNews = GsonUtil.fromJson(it.responseContent, ListCategory::class.java)
            it.status?.let {
                itemCategoryNews?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        }
    }

}
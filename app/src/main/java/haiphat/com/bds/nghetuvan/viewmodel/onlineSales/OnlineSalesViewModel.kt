package haiphat.com.bds.nghetuvan.viewmodel.onlineSales

import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.models.news.ListCategory
import haiphat.com.bds.nghetuvan.models.news.ListNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.models.onlineSales.BuildingResponse
import haiphat.com.bds.nghetuvan.models.onlineSales.TypeTableOfGoodsResponse
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

    fun getTypeTableOfGoods(onSuccess: (ArrayList<TypeTableOfGoodsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        OnlineSalesApi().getTypeTableOfGoods {
            it.status?.let {
                onSuccess(mockDataTypeTableOfGoods())
            } ?: onFailed(it.getErrorMessage())
        }
    }

    private fun mockDataTypeTableOfGoods(): ArrayList<TypeTableOfGoodsResponse> {
        var data = ArrayList<TypeTableOfGoodsResponse>()
        var building = ArrayList<BuildingResponse>()
        building.add(BuildingResponse(id = "1", name = "CT 1"))
        building.add(BuildingResponse(id = "2", name = "CT 2"))
        building.add(BuildingResponse(id = "3", name = "CT 3"))
        data.add(TypeTableOfGoodsResponse(id = "1", name = "Chung cư", data = building))
        return data
    }

}
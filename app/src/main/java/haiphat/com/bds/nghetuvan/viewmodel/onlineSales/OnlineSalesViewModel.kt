package haiphat.com.bds.nghetuvan.viewmodel.onlineSales

import haiphat.com.bds.nghetuvan.models.news.ListNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse
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

    fun getProjectTableOfGoods(onSuccess: (ArrayList<TypeTableOfGoodsResponse>) -> Unit, onFailed: (String?) -> Unit) {
//        OnlineSalesApi().getTypeTableOfGoods {
//            it.status?.let {
                onSuccess(mockDataTypeTableOfGoods())
//            } ?: onFailed(it.getErrorMessage())
//        }
    }

    fun getBuildingTableOfGoods(projectId : Int? ,onSuccess: (ArrayList<TypeTableOfGoodsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        onSuccess(mockDataBuilding())
    }

    private fun mockDataBuilding() : ArrayList<TypeTableOfGoodsResponse> {
        var building = ArrayList<TypeTableOfGoodsResponse>()
        building.add(TypeTableOfGoodsResponse(id = "1", name = "CT 1"))
        building.add(TypeTableOfGoodsResponse(id = "2", name = "CT 2"))
        building.add(TypeTableOfGoodsResponse(id = "3", name = "CT 3"))
        return building
    }

    private fun mockDataTypeTableOfGoods(): ArrayList<TypeTableOfGoodsResponse> {
        var data = ArrayList<TypeTableOfGoodsResponse>()
        data.add(TypeTableOfGoodsResponse(id = "1", name = "Chung cư"))
        data.add(TypeTableOfGoodsResponse(id = "2", name = "Biet thự "))
        data.add(TypeTableOfGoodsResponse(id = "3", name = "Đất nền"))
        return data
    }

}
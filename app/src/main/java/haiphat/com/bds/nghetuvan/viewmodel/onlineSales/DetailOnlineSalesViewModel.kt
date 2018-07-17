package haiphat.com.bds.nghetuvan.viewmodel.onlineSales

import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse

class DetailOnlineSalesViewModel {

    fun getInfoOnlineSales(onSuccess: (ArrayList<TypeTableOfGoodsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        onSuccess(mockDataInfoOnlineSales())
    }


    private fun mockDataInfoOnlineSales(): ArrayList<TypeTableOfGoodsResponse> {
        var data = ArrayList<TypeTableOfGoodsResponse>()
        data.add(TypeTableOfGoodsResponse(id = "1", name = "Hướng cửa"))
        data.add(TypeTableOfGoodsResponse(id = "2", name = "Hướng ban công "))
        data.add(TypeTableOfGoodsResponse(id = "3", name = "Số phòng ngủ"))
        data.add(TypeTableOfGoodsResponse(id = "3", name = "Nhà vệ sinh"))
        data.add(TypeTableOfGoodsResponse(id = "3", name = "diện tích tường"))
        data.add(TypeTableOfGoodsResponse(id = "3", name = "Diện tích thông thúy"))
        return data
    }

}
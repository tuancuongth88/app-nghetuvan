package haiphat.com.bds.nghetuvan.viewmodel

import haiphat.com.bds.nghetuvan.models.HomePageCategoryType
import haiphat.com.bds.nghetuvan.models.HomePageResponse
import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class HomePageViewModel {

    fun getItemHomePage(onSuccess : (ArrayList<CategoryPartnerResponse>) ->Unit, onFailed : (String?) -> Unit) {
            onSuccess(mockDataItem())
    }


    private fun mockDataItem() : ArrayList<CategoryPartnerResponse>{
        var listData = ArrayList<CategoryPartnerResponse>()
        listData.add(CategoryPartnerResponse(id = "1", name = "Chủ đầu tư"))
        listData.add(CategoryPartnerResponse(id = "2", name = "Chuyên viên tư vấn"))
        listData.add(CategoryPartnerResponse(id = "3", name = "tin tức chung"))
        listData.add(CategoryPartnerResponse(id = "4", name = "Ngân hàng"))
        listData.add(CategoryPartnerResponse(id = "5", name = "tin sự kiện"))
        return listData
    }
}
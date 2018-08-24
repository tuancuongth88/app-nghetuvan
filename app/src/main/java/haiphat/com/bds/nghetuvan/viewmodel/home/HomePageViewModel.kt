package haiphat.com.bds.nghetuvan.viewmodel.home

import haiphat.com.bds.nghetuvan.models.home.HomeCategoryResponse
import haiphat.com.bds.nghetuvan.models.home.HomePageResponse
import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class HomePageViewModel {

    fun getItemHomePage(onSuccess : (ArrayList<CategoryPartnerResponse>) ->Unit, onFailed : (String?) -> Unit) {
            onSuccess(mockDataItem())
    }

    fun getHomeCategory(onSuccess : (ArrayList<HomeCategoryResponse>) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockHomeCategoryItem())
    }


    private fun mockHomeCategoryItem() : ArrayList<HomeCategoryResponse>{
        val listData = ArrayList<HomeCategoryResponse>()
        listData.add(HomeCategoryResponse(id = "1", name = "Kho dự án", data = mockDataHomeItem()))
        listData.add(HomeCategoryResponse(id = "2", name = "Bán hàng online", data = mockDataHomeItem()))
        listData.add(HomeCategoryResponse(id = "3", name = "dự án", data = mockDataHomeItem()))
        return listData
    }

    private fun mockDataHomeItem() : ArrayList<HomePageResponse>{
      val item = ArrayList<HomePageResponse>()
        item.add(HomePageResponse(id = "1", name = "BĐS để ở", url = ""))
        item.add(HomePageResponse(id = "1", name = "BĐS đầu tư", url = ""))
        item.add(HomePageResponse(id = "1", name = "BĐS Cho thêu", url = ""))
        item.add(HomePageResponse(id = "1", name = "BĐS nghỉ dưỡng", url = ""))
        return item
    }

    private fun mockDataItem() : ArrayList<CategoryPartnerResponse>{
        val listData = ArrayList<CategoryPartnerResponse>()
//        listData.add(CategoryPartnerResponse(id = "1", name = "Chủ đầu tư"))
//        listData.add(CategoryPartnerResponse(id = "2", name = "Chuyên viên tư vấn"))
//        listData.add(CategoryPartnerResponse(id = "3", name = "tin tức chung"))
//        listData.add(CategoryPartnerResponse(id = "4", name = "Ngân hàng"))
//        listData.add(CategoryPartnerResponse(id = "5", name = "tin sự kiện"))
        return listData
    }
}
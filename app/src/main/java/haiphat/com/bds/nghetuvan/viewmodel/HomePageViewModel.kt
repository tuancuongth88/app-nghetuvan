package haiphat.com.bds.nghetuvan.viewmodel

import haiphat.com.bds.nghetuvan.models.HomePageCategoryType
import haiphat.com.bds.nghetuvan.models.HomePageResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class HomePageViewModel {

    fun getItemHomePage(onSuccess : (ArrayList<HomePageResponse>) ->Unit, onFailed : (String?) -> Unit) {
            onSuccess(mockDataItem())
    }

    private fun mockDataItem() : ArrayList<HomePageResponse>{
        var listData = ArrayList<HomePageResponse>()
        listData.add(HomePageResponse(name = "Chủ đầu tư", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", type = HomePageCategoryType.HomeInvestor))
        listData.add(HomePageResponse(name = "Chuyên viên tư vấn", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", type = HomePageCategoryType.HomeConsultants))
        listData.add(HomePageResponse(name = "tin tức chung", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", type = HomePageCategoryType.HomeGeneralNews))
        listData.add(HomePageResponse(name = "Ngân hàng", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", type = HomePageCategoryType.HomeBank))
        listData.add(HomePageResponse(name = "tin sự kiện", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", type = HomePageCategoryType.HomeEventNews))
        listData.add(HomePageResponse(name = "Tin mở bán", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", type = HomePageCategoryType.HomeNewsOpenSale))
        return listData
    }
}
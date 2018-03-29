package haiphat.com.bds.nghetuvan.viewmodel.partner

import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class PartnerViewModel {
    fun getItemPartner(onSuccess : (ArrayList<PartnerResponse>) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockDataItem())
    }

    private fun mockDataItem() : ArrayList<PartnerResponse>{
        var listData = ArrayList<PartnerResponse>()
        listData.add(PartnerResponse(name = "Chủ đầu tư", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", price = 100, time = "2013-01-04T", type = 5))
        listData.add(PartnerResponse(name = "Chuyên viên tư vấn", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", price = 12, time = "2013-01-04T", type = 1))
        listData.add(PartnerResponse(name = "tin tức chung", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", price = 15, time = "2013-01-04T", type = 4))
        listData.add(PartnerResponse(name = "Ngân hàng", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", price = 23, time = "2013-01-04T", type = 3))
        listData.add(PartnerResponse(name = "tin sự kiện", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", price = 31, time = "2013-01-04T", type = 2))
        listData.add(PartnerResponse(name = "Tin mở bán", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", price = 24, time = "2013-01-04T", type = 1))
        return listData
    }
}
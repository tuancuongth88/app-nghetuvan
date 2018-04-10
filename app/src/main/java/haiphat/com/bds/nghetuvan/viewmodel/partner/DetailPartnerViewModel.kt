package haiphat.com.bds.nghetuvan.viewmodel.partner

import haiphat.com.bds.nghetuvan.models.partner.ListPartnerResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class DetailPartnerViewModel {
    fun getDetailPartner(onSuccess : (ListPartnerResponse) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockDataItem())
    }

    private fun mockDataItem() : ListPartnerResponse {
        var detailNewsResponse = ListPartnerResponse()
//        detailNewsResponse.name = "Đầu tư Bất động sản 2018 – Cơ hội cho những nhà đầu tư thông thái"
//        detailNewsResponse.url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg"
        return detailNewsResponse
    }
}
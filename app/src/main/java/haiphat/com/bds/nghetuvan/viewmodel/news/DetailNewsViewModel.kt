package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.news.DetailNewsResponse
import haiphat.com.bds.nghetuvan.models.news.NewsResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class DetailNewsViewModel {
    fun getDetailNews(onSuccess : (DetailNewsResponse) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockDataItem())
    }

    private fun mockDataItem() : DetailNewsResponse{
        var detailNewsResponse = DetailNewsResponse()
        detailNewsResponse.name = "Đầu tư Bất động sản 2018 – Cơ hội cho những nhà đầu tư thông thái"
        detailNewsResponse.time = "120"
        detailNewsResponse.author = "Nguyen van si"
        detailNewsResponse.url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg"
        return detailNewsResponse
    }
}
package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.news.NewsResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class NewsViewModel {
    fun getItemNews(onSuccess : (ArrayList<NewsResponse>) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockDataItem())
    }

    private fun mockDataItem() : ArrayList<NewsResponse>{
        var listData = ArrayList<NewsResponse>()
        listData.add(NewsResponse(title = "Chủ đầu tư", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "Chiều 09/02/2018, sự kiện Tổng kết nghemoigioi.vn năm 2017 đã được diễn ra tại phòng Hội thảo tầng 2"))
        listData.add(NewsResponse(title = "Chuyên viên tư vấn", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "37 Nguyễn Ngọc Vũ, Cầu Giấy, Hà Nội. Dựa vào các tiêu chí đánh giá hoạt"))
        listData.add(NewsResponse(title = "tin tức chung", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "giá hoạt động trong năm 2017 của các Sàn liên kết, nghemoigioi.vn đã tìm ra 10 đơn"))
        listData.add(NewsResponse(title = "Ngân hàng", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "Sáng ngày 31/01/2018, theo lời mời của Ban lãnh đạo Tập đoàn CENGROUP"))
        listData.add(NewsResponse(title = "tin sự kiện", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "huấn luyện viên (HLV) trưởng của đội tuyển bóng đá U23 Việt Nam – Park Hang Seo"))
        listData.add(NewsResponse(title = "Tin mở bán", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "ACE nhà CEN, người hâm mộ tại CENGROUP."))
        return listData
    }
}
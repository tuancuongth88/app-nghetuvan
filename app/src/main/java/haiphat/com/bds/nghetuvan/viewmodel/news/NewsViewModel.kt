package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse
import haiphat.com.bds.nghetuvan.models.news.ListCategory
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.news.NewsApi

class NewsViewModel {
    fun getItemNews(onSuccess: (ArrayList<NewsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        onSuccess(mockDataItem())
    }

    fun getCategoryNews(onSuccess: (ArrayList<CategoryNewsResponse>) -> Unit, onFailed: (String?) -> Unit) {
        NewsApi().getCategory {
            var itemCategoryNews = GsonUtil.fromJson(it.responseContent, ListCategory::class.java)
            it?.isSuccess()?.let {
                itemCategoryNews?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        }
    }

    private fun mockDataItem(): ArrayList<NewsResponse> {
        var listData = ArrayList<NewsResponse>()
        listData.add(NewsResponse(type = 4, totalFeedback = 10, title = "HoREA “phản pháo” đề xuất quy định diện tích ở tối thiểu nhập hộ khẩu", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "Chiều 09/02/2018, sự kiện Tổng kết nghemoigioi.vn năm 2017 đã được diễn ra tại phòng Hội thảo tầng 2"))
        listData.add(NewsResponse(type = 5, totalFeedback = 1, title = "Đầu tư Bất động sản 2018 – Cơ hội cho những nhà đầu tư thông thái", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "37 Nguyễn Ngọc Vũ, Cầu Giấy, Hà Nội. Dựa vào các tiêu chí đánh giá hoạt"))
        listData.add(NewsResponse(type = 4, totalFeedback = 4, title = "Phúc Yên (tỉnh Vĩnh Phúc) vừa lên thành phố, giới đầu tư ồ ạt mua đất nền", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "giá hoạt động trong năm 2017 của các Sàn liên kết, nghemoigioi.vn đã tìm ra 10 đơn"))
        listData.add(NewsResponse(type = 5, totalFeedback = 7, title = "TMS ký kết hợp tác cùng CENLAND triển khai dự án TMS Grand City Phúc Yên", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "Sáng ngày 31/01/2018, theo lời mời của Ban lãnh đạo Tập đoàn CENGROUP"))
        listData.add(NewsResponse(type = 6, totalFeedback = 12, title = "Một năm bất động sản sôi động, hứa hẹn 2018 tiếp tục thành công", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "huấn luyện viên (HLV) trưởng của đội tuyển bóng đá U23 Việt Nam – Park Hang Seo"))
        listData.add(NewsResponse(type = 4, totalFeedback = 17, title = "Xuân tri ân – Tết đoàn viên tại dự án The K – Park", url = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", subTitle = "ACE nhà CEN, người hâm mộ tại CENGROUP."))
        return listData
    }
}
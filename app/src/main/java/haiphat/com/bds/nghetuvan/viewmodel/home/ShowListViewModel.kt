package haiphat.com.bds.nghetuvan.viewmodel.home

import haiphat.com.bds.nghetuvan.models.home.HomePageResponse

/**
 * Created by HUONG HA^P on 6/21/2018.
 */
class ShowListViewModel {

    fun getItem(onSuccess : (ArrayList<HomePageResponse>) ->Unit, onFailed : (String?) -> Unit){
        onSuccess(mockDataHomeItem())
    }


    private fun mockDataHomeItem() : ArrayList<HomePageResponse>{
        var item = ArrayList<HomePageResponse>()
        item.add(HomePageResponse(id = "1", name = "BĐS để ở", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS đầu tư", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS Cho thêu", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS nghỉ dưỡng", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS để ở", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS đầu tư", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS Cho thêu", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        item.add(HomePageResponse(id = "1", name = "BĐS nghỉ dưỡng", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", location = "12 nguyen trai"))
        return item
    }
}
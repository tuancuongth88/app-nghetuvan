package haiphat.com.bds.nghetuvan.viewmodel.project

import haiphat.com.bds.nghetuvan.models.project.ProjectSupportResponse

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class ProjectSupportViewModel {
    var id: String? = null

    fun getItemsSupport(onSuccess: (ArrayList<ProjectSupportResponse>?) -> Unit, onFailed: (String?) -> Unit) {
        onSuccess(mockData())
    }

    private fun mockData() : ArrayList<ProjectSupportResponse>{
        var item = ArrayList<ProjectSupportResponse>()
        item.add(ProjectSupportResponse(name = "Mr nguyen thi hàng",phone = "0984376743", url = null, email = "hang@gmail.com"))
        item.add(ProjectSupportResponse(name = "Mr nguyen thi pho",phone = "0984376743", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", email = "pho@gmail.com"))
        return item
    }

}

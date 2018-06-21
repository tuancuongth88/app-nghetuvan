package haiphat.com.bds.nghetuvan.viewmodel.project

import haiphat.com.bds.nghetuvan.models.project.ProjectWarehouseResponse

/**
 * Created by HUONG HA^P on 5/17/2018.
 */
class ProjectWarehouseViewModel {

    fun getItemProjectWarehouse(onSuccess : (ArrayList<ProjectWarehouseResponse>) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockProjectWarehouse())
    }


    private fun mockProjectWarehouse() : ArrayList<ProjectWarehouseResponse>{
        var list = ArrayList<ProjectWarehouseResponse>()
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "http://a9.vietbao.vn/images/vn999/170/2018/01/20180129-bo-tui-kinh-nghiem-vang-khi-mua-bat-dong-san-cao-cap-2018-1.jpg", localtion = "12 hai ba trung ha noi", type = 1))
        return list
    }
}
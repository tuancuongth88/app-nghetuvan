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
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "", localtion = "12 hai ba trung ha noi", type = 1))
        list.add(ProjectWarehouseResponse(name = "dự án mới ", url = "", localtion = "12 hai ba trung ha noi", type = 1))
        return list
    }
}
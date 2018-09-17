package haiphat.com.bds.nghetuvan.viewmodel.project

import haiphat.com.bds.nghetuvan.models.project.ListProjectWarehouseResponse
import haiphat.com.bds.nghetuvan.models.project.ProjectWarehouseResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.project.ProjectApi

/**
 * Created by HUONG HA^P on 5/17/2018.
 */
class ProjectWarehouseViewModel {

    var page : Int ?= 1

    fun getItemProjects(onSuccess : (ArrayList<ProjectWarehouseResponse>?) ->Unit, onFailed : (String?) -> Unit) {
        ProjectApi().getProject(onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ListProjectWarehouseResponse::class.java)
            if (it.isSuccess()){
                onSuccess(response?.data)
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }

}
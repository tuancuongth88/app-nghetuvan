package haiphat.com.bds.nghetuvan.viewmodel.education

import haiphat.com.bds.nghetuvan.models.ErrorModel
import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.models.education.ListEducationResponse
import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.education.EducationApi

class EducationDetailViewModel {

    var id : String ?= null
    var fullName : String ?= null
    var phone : String ?= null
    var email : String ?= null

    fun submitFormEducation(onSuccess : (String?)->Unit?, onFailed : (String?) -> Unit?){
        EducationApi(Config.HPACADEMY).postRegisterEducation(id, fullName, phone, email, onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ErrorModel::class.java)
            if (it.isSuccess()){
                response?.let { onSuccess(it.message) } ?: onFailed(it.getErrorMessage())
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }

    fun getCourseContent(onSuccess: (ArrayList<EducationResponse>?) -> Unit?, onFailed: (String?) -> Unit?) {
        EducationApi(Config.CRM).getCourseContent(id, onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ListEducationResponse::class.java)
            if (it.isSuccess()) {
                response?.let { onSuccess(it?.data) } ?: onFailed(it.getErrorMessage())
            } else {
                onFailed(it.getErrorMessage())
            }
        })
    }

}
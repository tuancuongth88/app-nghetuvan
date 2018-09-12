package haiphat.com.bds.nghetuvan.viewmodel.education

import haiphat.com.bds.nghetuvan.models.BaseResponse
import haiphat.com.bds.nghetuvan.models.education.ListCategoryEducationResponse
import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.models.education.ListEducationResponse
import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.education.EducationApi

class EducationViewModel {

    var id: Int? = null
    var page: Int = 1
    var numberRecord: Int = 10

    fun getCategoryEducation(onSuccess: (ArrayList<BaseResponse>?) -> Unit?, onFailed: (String?) -> Unit?) {
        EducationApi(Config.CRM).getCategoryItems {
            var response = GsonUtil.fromJson(it.responseContent, ListCategoryEducationResponse::class.java)
            if (it.isSuccess()) {
                response?.let { onSuccess(it.data) } ?: onFailed(it.getErrorMessage())
            } else {
                onFailed(it.getErrorMessage())
            }
        }
    }

    fun getItemEducation(onSuccess: (ArrayList<EducationResponse>?) -> Unit?, onFailed: (String?) -> Unit?) {
        EducationApi(Config.CRM).getItems(id, page.toString(), numberRecord.toString(), onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ListEducationResponse::class.java)
            if (it.isSuccess()) {
                response?.let { onSuccess(it?.data) } ?: onFailed(it.getErrorMessage())
            } else {
                onFailed(it.getErrorMessage())
            }
        })
    }

    fun getHotItems(onSuccess: (ArrayList<EducationResponse>?) -> Unit, onFailed: (String?) -> Unit?) {
        EducationApi(Config.CRM).getEducationHot(page.toString(), numberRecord.toString(), onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ListEducationResponse::class.java)
            if (it.isSuccess()) {
                response?.let { onSuccess(it?.data) } ?: onFailed(it.getErrorMessage())
            } else {
                onFailed(it.getErrorMessage())
            }
        })
    }

}
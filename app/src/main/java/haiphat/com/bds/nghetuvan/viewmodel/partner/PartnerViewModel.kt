package haiphat.com.bds.nghetuvan.viewmodel.partner

import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.ListCategoryPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.ListPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.partner.PartnerApi

class PartnerViewModel {
    var id : String? = null
    var page : Int? =1
    fun getItemPartner(onSuccess : (ArrayList<PartnerResponse>?) ->Unit, onFailed : (String?) -> Unit) {
        PartnerApi().getItemPartners(id, page.toString(), onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, ListPartnerResponse::class.java)
            if (it.isSuccess()){
                onSuccess(response?.data)
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }
    fun getCategoryPartner(onSuccess: (ArrayList<CategoryPartnerResponse>?) -> Unit, onFailed: (String?) -> Unit) {
        PartnerApi().getCategory {
            var itemCategoryNews = GsonUtil.fromJson(it.responseContent, ListCategoryPartnerResponse::class.java)
            if (it.isSuccess()){
                onSuccess(itemCategoryNews?.data)
            }else{
                onFailed(it.getErrorMessage())
            }
        }
    }
}
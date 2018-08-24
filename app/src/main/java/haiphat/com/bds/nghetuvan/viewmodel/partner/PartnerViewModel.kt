package haiphat.com.bds.nghetuvan.viewmodel.partner

import haiphat.com.bds.nghetuvan.models.partner.CategoryPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.ListCategoryPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.ListPartnerResponse
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.partner.PartnerApi

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class PartnerViewModel {
    var id : String? = null
    var page : Int? =1
    fun getItemPartner(onSuccess : (ArrayList<PartnerResponse>) ->Unit, onFailed : (String?) -> Unit) {
        PartnerApi().getItemNews(id, page.toString(), onResponse = {
            var listItemResponse = GsonUtil.fromJson(it.responseContent, ListPartnerResponse::class.java)
            it.status?.let {
                listItemResponse?.data?.let { it1 ->onSuccess(it1) }
            }?: onFailed(it.getErrorMessage())
        })
    }

    fun getCategoryPartner(onSuccess: (ArrayList<CategoryPartnerResponse>) -> Unit, onFailed: (String?) -> Unit) {
        PartnerApi().getCategory {
            var itemCategoryNews = GsonUtil.fromJson(it.responseContent, ListCategoryPartnerResponse::class.java)
            it.status?.let {
                itemCategoryNews?.data?.let { it1 -> onSuccess(it1) }
            } ?: onFailed(it.getErrorMessage())
        }
    }
}
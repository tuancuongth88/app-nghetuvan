package haiphat.com.bds.nghetuvan.models.partner

import haiphat.com.bds.nghetuvan.models.news.CategoryNewsResponse

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
data class ListCategoryPartnerResponse(var status: String? = null,
                                       var data: ArrayList<CategoryPartnerResponse>? = null,
                                       var message: String? = null
)
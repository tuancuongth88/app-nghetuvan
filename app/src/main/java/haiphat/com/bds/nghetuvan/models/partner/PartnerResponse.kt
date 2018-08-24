package haiphat.com.bds.nghetuvan.models.partner

import haiphat.com.bds.nghetuvan.models.BaseResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class PartnerResponse(var image_url: String? = null,
                           var phone: String? = null,
                           var detail: String? = null,
                           var email : String? = null,
                           var category : CategoryPartnerResponse? = null
//                           var created_at  :String? = null
):BaseResponse()
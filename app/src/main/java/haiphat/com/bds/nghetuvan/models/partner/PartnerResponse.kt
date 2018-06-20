package haiphat.com.bds.nghetuvan.models.partner

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class PartnerResponse(var id: String? = null,
                           var name: String? = null,
                           var image_url: String? = null,
                           var phone: String? = null,
                           var detail: String? = null,
                           var email : String? = null,
                           var category_id : Int? = 0
)
package haiphat.com.bds.nghetuvan.models.partner

import haiphat.com.bds.nghetuvan.models.HomePageCategoryType

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class PartnerResponse(var name: String? = null,
                           var time: String? = null,
                           var url: String? = null,
                           var price: Int? = 0,
                           var adder: String? = null,
                           var type : Int? = 0
)
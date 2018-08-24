package haiphat.com.bds.nghetuvan.models.news

import haiphat.com.bds.nghetuvan.models.BaseResponse

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class NewsResponse(var category : CategoryNewsResponse? = null,
                   var is_approve : Int? = 0,
                   var title: String? = null,
                   var author : AuthorResponse? = null,
                   var content: String? = null,
                   var image_url: String? = null,
                   var description : String? =null
//                 var created_at : String? =null
):BaseResponse()

class AuthorResponse: BaseResponse()

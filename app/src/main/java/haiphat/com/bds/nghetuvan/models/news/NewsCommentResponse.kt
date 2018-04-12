package haiphat.com.bds.nghetuvan.models.news

import haiphat.com.bds.nghetuvan.models.auth.UserResponse

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
data class NewsCommentResponse(
        var id: String? = null,
        var news_id : String? = null,
        var parent_id : String? = null,
        var total_comment : Int? = 0,
        var user : UserResponse? = null,
        var created_at : String? =null,
        var comment: String? = null
)
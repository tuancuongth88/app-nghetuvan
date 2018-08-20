package haiphat.com.bds.nghetuvan.models.news

import haiphat.com.bds.nghetuvan.models.auth.UserResponse


data class NewsCommentResponse(
        var id: String? = null,
        var news_id : String? = null,
        var parent_id : String? = null,
        var total_comment : Int? = 0,
        var user : UserResponse? = null,
        var created_at : String? =null,
        var comment: String? = null
)
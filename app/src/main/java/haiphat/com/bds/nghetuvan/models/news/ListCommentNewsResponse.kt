package haiphat.com.bds.nghetuvan.models.news

/**
 * Created by HUONG HA^P on 4/11/2018.
 */
data class ListCommentNewsResponse(
        var status: String? = null,
        var data: ArrayList<NewsCommentResponse>? = null,
        var message: String? = null
)

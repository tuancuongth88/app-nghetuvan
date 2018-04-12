package haiphat.com.bds.nghetuvan.models.news

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class NewsResponse(var id: String?= null,
                        var category_id : String? = null,
                        var is_approve : Int? = 0,
                        var title: String? = null,
                        var author : String? = null,
                        var content: String? = null,
                        var image_url: String? = null,
                        var total_comment : Int? =0
)

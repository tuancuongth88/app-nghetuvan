package haiphat.com.bds.nghetuvan.models.news

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class NewsResponse(var title: String? = null,
                        var subTitle: String? = null,
                        var url: String? = null,
                        var type : Int? =0,
                        var totalFeedback : Int? =0
)

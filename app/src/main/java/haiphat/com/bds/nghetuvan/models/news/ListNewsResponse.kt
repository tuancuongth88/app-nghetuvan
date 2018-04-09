package haiphat.com.bds.nghetuvan.models.news

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
data class ListNewsResponse(var status: String? = null,
                            var data: ArrayList<NewsResponse>? = null,
                            var message: String? = null
)
package haiphat.com.bds.nghetuvan.models.news

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
data class ListCategory(var status: String? = null,
                        var data: ArrayList<CategoryNewsResponse>? = null,
                        var message: String? = null
)
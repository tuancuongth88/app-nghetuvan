package haiphat.com.bds.nghetuvan.models.home

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class HomePageResponse(
        var id: String? = null,
        var name: String? = null,
        var location : String? = null,
        var url: String? = null,
        var type: HomePageCategoryType? = HomePageCategoryType.Undefined
)
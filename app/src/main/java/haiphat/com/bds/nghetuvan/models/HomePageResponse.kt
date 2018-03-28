package haiphat.com.bds.nghetuvan.models

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
data class HomePageResponse (
    var name: String? = null,
    var url : String? = null,
    var type : HomePageCategoryType? = HomePageCategoryType.Undefined
)
package haiphat.com.bds.nghetuvan.models.home

data class HomePageResponse(
        var id: String? = null,
        var name: String? = null,
        var location : String? = null,
        var url: String? = null,
        var type: HomePageCategoryType? = HomePageCategoryType.Undefined
)
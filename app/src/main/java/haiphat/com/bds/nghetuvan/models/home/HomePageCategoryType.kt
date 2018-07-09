package haiphat.com.bds.nghetuvan.models.home

import haiphat.com.bds.nghetuvan.BaseApplication
import haiphat.com.bds.nghetuvan.R

enum class HomePageCategoryType(var type : Int) {
    Undefined(0),
    HomeInvestor(1),
    HomeConsultants(2),
    HomeBank(3),
    HomeGeneralNews(4),
    HomeEventNews(5),
    HomeNewsOpenSale(6)

}

fun HomePageCategoryType.convertCourseType() : String{
    var str = ""
    when(this.type){
        HomePageCategoryType.HomeInvestor.type -> {
            str = BaseApplication.context.getString(R.string.text_investor)
        }
        HomePageCategoryType.HomeConsultants.type -> {
            str = BaseApplication.context.getString(R.string.text_consultants)
        }
        HomePageCategoryType.HomeBank.type -> {
            str = BaseApplication.context.getString(R.string.text_bank)
        }
        HomePageCategoryType.HomeGeneralNews.type -> {
            str = BaseApplication.context.getString(R.string.text_general_news)
        }
        HomePageCategoryType.HomeEventNews.type -> {
            str = BaseApplication.context.getString(R.string.text_event_news)
        }
        HomePageCategoryType.HomeNewsOpenSale.type -> {
            str = BaseApplication.context.getString(R.string.text_news_open_sale)
        }
    }
    return str
}
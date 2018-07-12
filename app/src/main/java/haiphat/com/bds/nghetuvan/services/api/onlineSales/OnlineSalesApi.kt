package haiphat.com.bds.nghetuvan.services.api.onlineSales

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.HashMap

class OnlineSalesApi : BaseApi() {
    override fun apiUrl(): String? {
        return "package/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun getTypeTableOfGoods(onResponse: (DgmResponse) -> Unit) {
        this["tables", onResponse]
    }

    fun getTableOfGoods(categoryId: String?, building : String?, onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        params.put("category_id", categoryId ?: "")
        params.put("building", building ?: "")
        val queryString = this.parseUrlQueryStringWithParams("table-by-building?{category_id}&{building}", params)
        this[queryString, onResponse]
    }

}
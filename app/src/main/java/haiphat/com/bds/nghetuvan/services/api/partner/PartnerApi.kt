package haiphat.com.bds.nghetuvan.services.api.partner

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.HashMap

class PartnerApi : BaseApi() {
    override fun apiUrl(): String? {
        return "partners/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL_MEDIA
    }

    fun getCategory(onResponse: (DgmResponse) -> Unit) {
        this["categories", onResponse]
    }

    fun getItemNews(id: String?, page : String,  onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        params.put("page", page)
        val queryString = this.parseUrlQueryStringWithParams("category/" +id+ "?{page}", params)
        this[queryString, onResponse]
    }


}
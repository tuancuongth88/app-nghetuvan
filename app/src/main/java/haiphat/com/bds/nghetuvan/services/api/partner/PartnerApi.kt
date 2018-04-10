package haiphat.com.bds.nghetuvan.services.api.partner

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.HashMap

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class PartnerApi : BaseApi() {
    override fun apiUrl(): String? {
        return "partner/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun getCategory(onResponse: (DgmResponse) -> Unit) {
        this.get("category-partner", onResponse)
    }

    fun getItemNews(id: String?, onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        params.put("id", id ?: "")
        val queryString = this.parseUrlWithParams("partner-by-category/{id}", params)
        this.get(queryString, onResponse)
    }


}
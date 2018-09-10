package haiphat.com.bds.nghetuvan.services.api.customers

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi

class CustomersApi : BaseApi() {
    override fun apiUrl(): String? {
        return "customers/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL_CRM
    }

    fun getItems(name: String?, page: String?, numberRecord: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("name", name ?: "")
        data.put("page", page ?: "")
        data.put("number_record", numberRecord ?: "")
        val queryString = this.parseUrlQueryStringWithParams("list?{name}&{page}&{number_record}", data)
        this[queryString, onResponse]
    }
}
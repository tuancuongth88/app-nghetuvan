package haiphat.com.bds.nghetuvan.services.api.education

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi

class EducationApi : BaseApi(){

    override fun apiUrl(): String? {
        return "educations/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL_CRM
    }

    fun getCategoryItems( onResponse: (DgmResponse) -> Unit) {
        this["programs/list", onResponse]
    }

    fun getItems(id: String?, page: String?, numberRecord: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("name", id ?: "")
        data.put("page", page ?: "")
        data.put("number_record", numberRecord ?: "")
        val queryString = this.parseUrlQueryStringWithParams("subjects/category?{name}&{page}&{number_record}", data)
        this[queryString, onResponse]
    }
}
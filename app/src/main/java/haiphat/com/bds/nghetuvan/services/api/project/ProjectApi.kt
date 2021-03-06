package haiphat.com.bds.nghetuvan.services.api.project

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.HashMap

class ProjectApi : BaseApi(){
    override fun apiUrl(): String? {
        return "project/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun getProject(page : String?, onResponse: (DgmResponse) -> Unit){
        val params = HashMap<String, String>()
        params.put("page", page ?: "")
        val queryString = this.parseUrlQueryStringWithParams("get-projects?{page}", params)
        this[queryString, onResponse]
    }
}
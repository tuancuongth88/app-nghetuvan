package haiphat.com.bds.nghetuvan.services.api.education

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi

class EducationApi(var type : Int) : BaseApi(){

    override fun apiUrl(): String? {
        return "educations/"
    }

    override fun getEndPoint(): String? {
        when(type){
            Config.CRM -> return Config.API_URL_CRM
            Config.HPACADEMY -> return Config.API_URL_HPACADEMY
        }
        return null
    }

    fun getCategoryItems( onResponse: (DgmResponse) -> Unit) {
        this["programs/list", onResponse]
    }

    fun getItems(id: Int?, page: String?, numberRecord: String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("id", id.toString() ?: "")
        data.put("page", page ?: "")
        data.put("number_record", numberRecord ?: "")
        val queryString = this.parseUrlQueryStringWithParams("subjects/category?{id}&{page}&{number_record}", data)
        this[queryString, onResponse]
    }


    fun getEducationHot( onResponse: (DgmResponse) -> Unit) {
        this["hot", onResponse]
    }

    fun getCourseContent(id : String?, onResponse: (DgmResponse) -> Unit){
        val data = HashMap<String, String>()
        data.put("id", id ?: "")
        val queryString = this.parseUrlQueryStringWithParams("lessons/detail?{id}", data)
        this[queryString, onResponse]
    }

    fun postRegisterEducation(subject_id : String?, fullName : String?, phone : String?, email : String?, onResponse: (DgmResponse) -> Unit) {
        val data = HashMap<String, String>()
        data.put("subject_id", subject_id ?: "")
        data.put("fullname", fullName ?: "")
        data.put("phone", phone ?: "")
        data.put("email", email ?: "")
        this.post("subjects/register", data, onResponse)
    }

}
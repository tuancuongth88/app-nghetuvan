package haiphat.com.bds.nghetuvan.services.api.news

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.HashMap

class NewsApi : BaseApi() {
    override fun apiUrl(): String? {
        return "news/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL_MEDIA
    }

    fun getCategory(onResponse: (DgmResponse) -> Unit) {
        this["categories", onResponse]
    }

    fun getItemNews(id: String?, pages : String, onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        params.put("page", pages)
        val queryString = this.parseUrlQueryStringWithParams("category/"+id+"?{page}", params)
        this[queryString, onResponse]
    }

    fun getListComment(id: String?, onResponse: (DgmResponse) -> Unit){
        val params = HashMap<String, String>()
        params.put("id", id ?: "")
        val queryString = this.parseUrlWithParams("list-comment-by-news/{id}", params)
        this[queryString, onResponse]
    }

    fun postComment(id: String?, userId : String?, parentId : String?, comment : String?, onResponse: (DgmResponse) -> Unit){
        val params = HashMap<String, String>()
        params.put("user_id", userId ?: "")
        params.put("parent_id", parentId ?: "")
        params.put("comment", comment ?: "")
//        val queryString = this.parseUrlQueryStringWithParams("post-comment-by-news/"+id+"?{user_id}&{parent_id}&{comment}", params)
        this.upload("post-comment-by-news/"+id, params, onResponse)

    }

}
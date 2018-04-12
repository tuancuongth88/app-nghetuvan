package haiphat.com.bds.nghetuvan.services.api.news

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi
import java.util.HashMap

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class NewsApi : BaseApi() {
    override fun apiUrl(): String? {
        return "news/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun getCategory(onResponse: (DgmResponse) -> Unit) {
        this.get("category-news", onResponse)
    }

    fun getItemNews(id: String?, current: String?, perpages : String, onResponse: (DgmResponse) -> Unit) {
        val params = HashMap<String, String>()
        params.put("current", current ?: "")
        params.put("perpages", perpages ?: "")
        val queryString = this.parseUrlQueryStringWithParams("news-by-category/"+id+"?{current}&{perpages}", params)
        this.get(queryString, onResponse)
    }

    fun getListComment(id: String?, onResponse: (DgmResponse) -> Unit){
        val params = HashMap<String, String>()
        params.put("id", id ?: "")
        val queryString = this.parseUrlWithParams("list-comment-by-news/{id}", params)
        this.get(queryString, onResponse)
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
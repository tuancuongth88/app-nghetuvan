package haiphat.com.bds.nghetuvan.viewmodel.news

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class NewsCommentViewModel {
    var content: String? = null
    var newsId: String? = null
    var parentId : Int? =0

//    fun getListComment(onSuccess: (ArrayList<NewsCommentResponse>) -> Unit, onFailed: (String?) -> Unit) {
//        NewsApi().getListComment(newsId, onResponse = {
//            val dataResponse = GsonUtil.fromJson(it.responseContent, ListCommentNewsResponse::class.java)
//            it.status?.let {
//                dataResponse?.data?.let { it1 -> onSuccess(it1) }
//            } ?: onFailed(it.getErrorMessage())
//        })
//    }

//    fun postComment(onSuccess: (String?) -> Unit, onFailed: (String?) -> Unit){
//        NewsApi().postComment(newsId, UserServices.userInfo?.id, parentId.toString(), content,onResponse = {
//            if (it.status == 200){
//                onSuccess(BaseApplication.context.getString(R.string.text_post_comment_successfull))
//            }else{
//                onFailed(it.getErrorMessage())
//            }
//        })
//    }
}
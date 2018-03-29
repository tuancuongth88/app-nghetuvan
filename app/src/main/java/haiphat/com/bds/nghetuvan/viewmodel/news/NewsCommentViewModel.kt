package haiphat.com.bds.nghetuvan.viewmodel.news

import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
class NewsCommentViewModel {
    var content: String? = null

    fun replyDiscussion(onSuccess: () -> Unit, onFailed: (String?) -> Unit) {
        onSuccess()
    }

    fun getItemNewsComment(onSuccess: (ArrayList<NewsCommentResponse>) -> Unit, onFailed: (String?) -> Unit) {
        onSuccess(mockDataComment())
    }

    private fun mockDataComment(): ArrayList<NewsCommentResponse> {
        var listNewsComment = ArrayList<NewsCommentResponse>()
        listNewsComment.add(NewsCommentResponse(content = "MVV Coaching sẽ trang bị cho người học kỹ năng thuyết trình hiệu quả.",
                name = "Kevin Maxwell", urlAvatar = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", date = "2013-01-04T"))
        listNewsComment.add(NewsCommentResponse(content = "MVV Coaching sẽ trang bị cho người học kỹ năng thuyết trình hiệu quả.",
                name = "Kevin Maxwell", urlAvatar = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", date = "2013-01-04T"))
        listNewsComment.add(NewsCommentResponse(content = "MVV Coaching sẽ trang bị cho người học kỹ năng thuyết trình hiệu quả.",
                name = "Kevin Maxwell", urlAvatar = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", date = "2013-01-04T"))
        listNewsComment.add(NewsCommentResponse(content = "MVV Coaching sẽ trang bị cho người học kỹ năng thuyết trình hiệu quả.",
                name = "Kevin Maxwell", urlAvatar = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", date = "2013-01-04T"))
        listNewsComment.add(NewsCommentResponse(content = "MVV Coaching sẽ trang bị cho người học kỹ năng thuyết trình hiệu quả.",
                name = "Kevin Maxwell", urlAvatar = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", date = "2013-01-04T"))
        listNewsComment.add(NewsCommentResponse(content = "MVV Coaching sẽ trang bị cho người học kỹ năng thuyết trình hiệu quả.",
                name = "Kevin Maxwell", urlAvatar = "http://channel.mediacdn.vn/prupload/164/2017/06/img20170604223648469.jpg", date = "2013-01-04T"))
        return listNewsComment
    }
}
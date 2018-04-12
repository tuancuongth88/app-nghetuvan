package haiphat.com.bds.nghetuvan.adapter.news

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.news.NewsCommentResponse
import haiphat.com.bds.nghetuvan.utils.extensions.formatDateTime
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_news_detail_comment.view.*

/**
 * Created by DEV-01 on 12/29/2017.
 */
class NewsDetailCommentAdapter(private val list: ArrayList<NewsCommentResponse>) : RecyclerView.Adapter<NewsDetailCommentAdapter.NewsCommentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsCommentViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_news_detail_comment, parent, false)
        return NewsCommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsCommentViewHolder?, position: Int) {
        holder?.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NewsCommentViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(newsCommentResponse: NewsCommentResponse) {
            itemView.rivAvatar.fromUrl(newsCommentResponse?.user?.avatar, placeHolder = R.drawable.ic_defaut_avatar)
            itemView.tvName.text = newsCommentResponse?.user?.fullname
            itemView.tvTime.text = newsCommentResponse.created_at?.formatDateTime("dd/MM/yyyy")
            itemView.tvContent.text = newsCommentResponse?.comment
        }
    }
}
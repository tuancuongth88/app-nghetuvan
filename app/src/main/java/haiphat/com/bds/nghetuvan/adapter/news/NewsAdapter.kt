package haiphat.com.bds.nghetuvan.adapter.news

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.news.NewsResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrlFixData
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class NewsAdapter(private var listMyCourse: ArrayList<NewsResponse>?, private var onClick: (NewsResponse?) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_news, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder?.bindItem(listMyCourse?.get(position))
        holder?.itemView?.setOnClickListener {
            onClick(listMyCourse?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return listMyCourse?.size ?: 0
    }

    class NewsViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(newsResponse: NewsResponse?) {
            itemView.imgCover.fromUrlFixData("http://media.haiphatland.com.vn" + newsResponse?.image_url, placeHolder = R.drawable.ic_defaul_bg_my_course)
            itemView.tvName.text = newsResponse?.name
            itemView.tvDescription.text = newsResponse?.description
        }
    }
}
package haiphat.com.bds.nghetuvan.adapter.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.home.HomeCategoryResponse
import kotlinx.android.synthetic.main.item_document.view.*

/**
 * Created by HUONG HA^P on 6/20/2018.
 */
class DocumentAdapter(private val listHomePage: ArrayList<HomeCategoryResponse>, val onClick: (HomeCategoryResponse) -> Unit) : RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DocumentViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_document, parent, false)
        return DocumentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder?, position: Int) {
        holder?.itemView?.rippleDownload?.setOnRippleCompleteListener {
            onClick(listHomePage[position])
        }
        holder?.bindItem(listHomePage[position])
    }

    override fun getItemCount(): Int {
        return listHomePage.size
    }

    class DocumentViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(homeCategoryResponse: HomeCategoryResponse) {
            itemView.tvName.text = homeCategoryResponse.name
        }
    }
}
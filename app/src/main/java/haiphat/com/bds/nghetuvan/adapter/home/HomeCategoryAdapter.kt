package haiphat.com.bds.nghetuvan.adapter.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.home.HomeCategoryResponse
import kotlinx.android.synthetic.main.item_home_category.view.*

class HomeCategoryAdapter (private val listHomePage: ArrayList<HomeCategoryResponse>, val onClick: (HomeCategoryResponse) -> Unit) : RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_home_category, parent, false)
        return HomeCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder?.itemView?.rippleShow?.setOnRippleCompleteListener {
            onClick(listHomePage[position])
        }
        holder?.bindItem(listHomePage[position])
    }

    override fun getItemCount(): Int {
        return listHomePage.size
    }

    class HomeCategoryViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(homeCategoryResponse: HomeCategoryResponse) {
            itemView.tvName.text = homeCategoryResponse.name
            val recyclerView = itemView.rvHomeItem
            val adapter = HomeAdapter(homeCategoryResponse.data, onClick = {
//                var intent = Intent(itemView.context, PartnerDetailActivity::class.java)
//                itemView.context.startActivity(intent)
            })
            recyclerView.layoutManager = GridLayoutManager(itemView.context, 2)
            recyclerView.adapter = adapter
        }
    }
}
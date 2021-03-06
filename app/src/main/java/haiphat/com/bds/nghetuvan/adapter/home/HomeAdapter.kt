package haiphat.com.bds.nghetuvan.adapter.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.home.HomePageResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val listHomePage: ArrayList<HomePageResponse>?, val onClick: (HomePageResponse) -> Unit) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_home, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder?.itemView?.rippleItem?.setOnRippleCompleteListener {
            listHomePage?.get(position)?.let { it1 -> onClick(it1) }
        }
        holder?.bindItem(listHomePage?.get(position))
    }

    override fun getItemCount(): Int {
        return listHomePage?.size ?: 0
    }

    class HomeViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(homePageResponse: HomePageResponse?) {
            itemView.imgCategory.fromUrl(homePageResponse?.url, placeHolder = R.drawable.ic_defaul_bg_my_course)
            itemView.tvName.text = homePageResponse?.name
        }
    }
}
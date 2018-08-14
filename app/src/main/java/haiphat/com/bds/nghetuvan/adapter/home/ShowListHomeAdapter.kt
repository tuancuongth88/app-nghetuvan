package haiphat.com.bds.nghetuvan.adapter.home

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.home.HomePageResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_show_list_home.view.*

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
class ShowListHomeAdapter(private val listHomePage: ArrayList<HomePageResponse>?, val onClick: (HomePageResponse) -> Unit) : RecyclerView.Adapter<ShowListHomeAdapter.ShowListHomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowListHomeViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_show_list_home, parent, false)
        return ShowListHomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowListHomeViewHolder, position: Int) {
        holder?.itemView?.rippleItem?.setOnRippleCompleteListener {
            listHomePage?.get(position)?.let { it1 -> onClick(it1) }
        }
        holder?.bindItem(listHomePage?.get(position))
    }

    override fun getItemCount(): Int {
        return listHomePage?.size ?: 0
    }

    class ShowListHomeViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(homePageResponse: HomePageResponse?) {
            itemView.imgCategory.fromUrl(homePageResponse?.url, placeHolder = R.drawable.ic_defaul_bg_my_course)
            itemView.tvName.text = homePageResponse?.name
            itemView.tvLocation.text = homePageResponse?.location
        }
    }
}
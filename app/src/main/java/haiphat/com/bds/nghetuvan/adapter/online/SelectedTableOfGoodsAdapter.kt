package haiphat.com.bds.nghetuvan.adapter.online

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse
import kotlinx.android.synthetic.main.item_selected_table_of_goods.view.*

class SelectedTableOfGoodsAdapter(private val listHomePage: ArrayList<TypeTableOfGoodsResponse>, val onClick: (TypeTableOfGoodsResponse) -> Unit) : RecyclerView.Adapter<SelectedTableOfGoodsAdapter.TableOfGoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TableOfGoodsViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_selected_table_of_goods, parent, false)
        return TableOfGoodsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TableOfGoodsViewHolder?, position: Int) {
        holder?.itemView?.rippleItem?.setOnRippleCompleteListener {
            onClick(listHomePage[position])
        }
        holder?.bindItem(listHomePage[position])
    }

    override fun getItemCount(): Int {
        return listHomePage.size
    }

    class TableOfGoodsViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(typeTableOfGoodsResponse: TypeTableOfGoodsResponse) {
            itemView.tvInfoAccount.text = typeTableOfGoodsResponse.name
        }
    }
}
package haiphat.com.bds.nghetuvan.adapter.online

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse
import kotlinx.android.synthetic.main.item_selected_table_of_goods.view.*

class InfoOnlineSalesAdapter(private val listHomePage: ArrayList<TypeTableOfGoodsResponse>) : RecyclerView.Adapter<InfoOnlineSalesAdapter.TableOfGoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TableOfGoodsViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_selected_table_of_goods, parent, false)
        return TableOfGoodsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TableOfGoodsViewHolder?, position: Int) {
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
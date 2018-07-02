package haiphat.com.bds.nghetuvan.adapter.education

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.education.ItemEducationResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_education.view.*

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class EducationAdapter(private var listMyCourse: ArrayList<ItemEducationResponse>, private var onClick: (ItemEducationResponse) -> Unit) : RecyclerView.Adapter<EducationAdapter.PartnerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PartnerViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_education, parent, false)
        return PartnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PartnerViewHolder?, position: Int) {
        holder?.bindItem(listMyCourse[position])
        holder?.itemView?.rippleItem?.setOnRippleCompleteListener{
            onClick(listMyCourse[position])
        }
    }

    override fun getItemCount(): Int {
        return listMyCourse.size
    }

    class PartnerViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(partnerResponse: ItemEducationResponse) {
            itemView.tvName.text = partnerResponse.title
            itemView.imgCategory.fromUrl(partnerResponse.url, placeHolder = R.drawable.ic_defaul_bg_my_course)
            itemView.tvTime.text = partnerResponse.time
            itemView.tvOrganizationalUnits.text = partnerResponse.address
        }
    }
}
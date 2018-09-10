package haiphat.com.bds.nghetuvan.adapter.education

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_education.view.*

class EducationAdapter(private var listMyCourse: ArrayList<EducationResponse>?, private var onClick: (EducationResponse?) -> Unit) : RecyclerView.Adapter<EducationAdapter.PartnerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnerViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_education, parent, false)
        return PartnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PartnerViewHolder, position: Int) {
        holder?.bindItem(listMyCourse?.get(position))
        holder?.itemView?.rippleItem?.setOnRippleCompleteListener{
            onClick(listMyCourse?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return listMyCourse?.size ?: 0
    }

    class PartnerViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(partnerResponse: EducationResponse?) {
            itemView.tvName.text = partnerResponse?.name
            itemView.imgCategory.fromUrl(partnerResponse?.url, placeHolder = R.drawable.ic_defaul_bg_my_course)
            itemView.tvTime.text = partnerResponse?.open_time
        }
    }
}
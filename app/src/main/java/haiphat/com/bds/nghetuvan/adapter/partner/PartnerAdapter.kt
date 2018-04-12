package haiphat.com.bds.nghetuvan.adapter.partner

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.convertCourseType
import haiphat.com.bds.nghetuvan.models.partner.PartnerResponse
import haiphat.com.bds.nghetuvan.utils.CommonUtil
import haiphat.com.bds.nghetuvan.utils.extensions.convertToDateTime
import haiphat.com.bds.nghetuvan.utils.extensions.formatDate
import haiphat.com.bds.nghetuvan.utils.extensions.formatDateTime
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_partner.view.*

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class PartnerAdapter(private var listMyCourse: ArrayList<PartnerResponse>, private var onClick: (PartnerResponse) -> Unit) : RecyclerView.Adapter<PartnerAdapter.PartnerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PartnerViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_partner, parent, false)
        return PartnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PartnerViewHolder?, position: Int) {
        holder?.bindItem(listMyCourse[position])
        holder?.itemView?.setOnClickListener {
            onClick(listMyCourse[position])
        }
    }

    override fun getItemCount(): Int {
        return listMyCourse.size
    }

    class PartnerViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(partnerResponse: PartnerResponse) {
            itemView.tvName.text = partnerResponse.name
            itemView.rivAvatar.fromUrl(partnerResponse.image_url, placeHolder = R.drawable.ic_defaut_avatar)
            itemView.tvPhone.text = partnerResponse.phone
            itemView.tvEmail.text = partnerResponse.email
        }
    }
}
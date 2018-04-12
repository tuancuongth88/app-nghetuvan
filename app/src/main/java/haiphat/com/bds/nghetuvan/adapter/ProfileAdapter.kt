package haiphat.com.bds.nghetuvan.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.profiles.ProfileModel
import kotlinx.android.synthetic.main.item_profile.view.*

/**
 * Created by HUONG HA^P on 4/12/2018.
 */
class ProfileAdapter(private val profileActions: ArrayList<ProfileModel>, val onClick: (ProfileModel) -> Unit) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProfileViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_profile, parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder?, position: Int) {
        holder?.itemView?.setOnClickListener {
            onClick(profileActions[position])
        }
        holder?.bindItem(profileActions[position])
    }

    override fun getItemCount(): Int {
        return profileActions.size
    }

    class ProfileViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(profileModel: ProfileModel) {
            if (profileModel.name == itemView.context.getString(R.string.log_out)) {
                itemView?.tvInfoAccount?.setTextColor(ContextCompat.getColor(itemView.context, R.color.textLabelForgotPassword))
            } else {
                itemView?.tvInfoAccount?.setTextColor(ContextCompat.getColor(itemView.context, R.color.textLabel))
            }
            itemView.imgInfoAccount.setImageResource(profileModel.imgResource ?: 0)
            itemView.tvInfoAccount.text = profileModel.name
            itemView.imgInfoNext.setImageResource(profileModel.imgNext ?: 0)
        }
    }
}
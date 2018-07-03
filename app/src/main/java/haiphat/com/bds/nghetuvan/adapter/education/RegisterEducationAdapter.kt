package haiphat.com.bds.nghetuvan.adapter.education

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import kotlinx.android.synthetic.main.item_register_education.view.*

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
class RegisterEducationAdapter(private var listMyCourse: ArrayList<String>?, private var onClick: (String) -> Unit) : RecyclerView.Adapter<RegisterEducationAdapter.RegisterEducationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RegisterEducationViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_register_education, parent, false)
        return RegisterEducationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RegisterEducationViewHolder?, position: Int) {
        listMyCourse?.get(position)?.let {
            holder?.bindItem(it)
        }
        holder?.itemView?.rippleItem?.setOnRippleCompleteListener{
            listMyCourse?.get(position)?.let { onClick(it) }
        }
    }

    override fun getItemCount(): Int {
        return listMyCourse?.size ?: 0
    }

    class RegisterEducationViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(question: String) {
            itemView.tvQuestion.text = question
        }
    }
}
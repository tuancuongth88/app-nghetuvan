package haiphat.com.bds.nghetuvan.adapter.project

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.project.ProjectWarehouseResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import kotlinx.android.synthetic.main.item_project_warehouse.view.*


class ProjectWarehouseAdapter(private val list: ArrayList<ProjectWarehouseResponse>, val onClick: (ProjectWarehouseResponse) -> Unit) : RecyclerView.Adapter<ProjectWarehouseAdapter.ProjectWarehouseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectWarehouseViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_project_warehouse, parent, false)
        return ProjectWarehouseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectWarehouseViewHolder, position: Int) {
        holder?.itemView?.setOnClickListener {
            onClick(list[position])
        }
        holder?.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ProjectWarehouseViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(profileModel: ProjectWarehouseResponse) {
            itemView.imgProjectWarehouse.fromUrl(url = "", placeHolder = R.drawable.ic_defaul_bg_my_course)
            itemView.tvName.text = profileModel.name
            itemView.txtType.text = profileModel.type.toString()
            itemView.txtLocation.text = profileModel.location
        }
    }
}
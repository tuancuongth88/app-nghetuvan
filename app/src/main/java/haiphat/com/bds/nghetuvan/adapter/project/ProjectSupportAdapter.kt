package haiphat.com.bds.nghetuvan.adapter.project

/**
 * Created by HUONG HA^P on 3/29/2018.
 */
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.project.ProjectSupportResponse
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrlFixData
import kotlinx.android.synthetic.main.item_project_support.view.*

/**
 * Created by DEV-01 on 12/29/2017.
 */
class ProjectSupportAdapter(private val list: ArrayList<ProjectSupportResponse>?) : RecyclerView.Adapter<ProjectSupportAdapter.ProjectSupportViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectSupportViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_project_support, parent, false)
        return ProjectSupportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectSupportViewHolder, position: Int) {
        holder?.bindItem(list?.get(position))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class ProjectSupportViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(projectSupportResponse: ProjectSupportResponse?) {
            itemView.rivAvatar.fromUrlFixData(projectSupportResponse?.url, placeHolder = R.drawable.ic_defaut_avatar)
            itemView.tvName.text = projectSupportResponse?.name
            itemView.tvContent.text = projectSupportResponse?.name
            itemView.tvPhone.text = projectSupportResponse?.phone
            itemView.tvEmail.text = projectSupportResponse?.email
        }
    }
}
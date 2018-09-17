package haiphat.com.bds.nghetuvan.view.fragment.projectwarehouse

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.project.ProjectWarehouseAdapter
import haiphat.com.bds.nghetuvan.constants.IntentActionKeys
import haiphat.com.bds.nghetuvan.databinding.FragmentProjectWarehouseBinding
import haiphat.com.bds.nghetuvan.models.project.ProjectWarehouseResponse
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import haiphat.com.bds.nghetuvan.view.project.ProjectWareHouseDetailActivity
import haiphat.com.bds.nghetuvan.viewmodel.project.ProjectWarehouseViewModel

class ProjectWarehouseFragment: BaseFragment(){

    private lateinit var dataBindingFragmentProjectWarehouse: FragmentProjectWarehouseBinding
    private var projectWarehouseViewModel = ProjectWarehouseViewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentProjectWarehouse = DataBindingUtil.inflate(inflater, R.layout.fragment_project_warehouse, container, false)
        context?.let {
            (activity as HomeActivity).setBackgroundColor(ContextCompat.getColor(it, R.color.colorPrimary))
        }
        getItemProjectWarehouse()
        return dataBindingFragmentProjectWarehouse.root
    }

    private fun initViewAdapter(list: ArrayList<ProjectWarehouseResponse>?){
        var recyclerView = dataBindingFragmentProjectWarehouse.rvProjectWarehouse
        var adapter = ProjectWarehouseAdapter(list, onClick = {
            val intent = Intent(activity, ProjectWareHouseDetailActivity::class.java)
            it?.let {
                intent.putExtra(IntentActionKeys.KEY_PROJECT_WARE_HOUSE, GsonUtil.toJson(it))
            }
            startActivity(intent)
        })
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun getItemProjectWarehouse(){
        projectWarehouseViewModel.getItemProjects(onSuccess = {
            initViewAdapter(it)
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
        })
    }

}
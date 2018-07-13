package haiphat.com.bds.nghetuvan.utils.dialog

import android.app.Activity
import android.app.Dialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.online.SelectedTableOfGoodsAdapter
import haiphat.com.bds.nghetuvan.databinding.DialogSelectedTableOfGoodBinding
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse

/**
 * Created by sivan on 7/13/2018.
 */
class DialogSelectTableOfGoods(var activity : Activity , private var listTable : ArrayList<TypeTableOfGoodsResponse>,
                               var onClick : (TypeTableOfGoodsResponse?)-> Unit?): Dialog(activity){

    private lateinit var dataBinding : DialogSelectedTableOfGoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.dialog_selected_table_of_good, null, false)
        setContentView(dataBinding.root)
        initAdapter(listTable)
    }

    private fun initAdapter(list : ArrayList<TypeTableOfGoodsResponse>){
        val recyclerView = dataBinding.rvSelectedTableOfGoods
        val adapter = SelectedTableOfGoodsAdapter(list, onClick = {
            onClick(it)
            dismiss()
        })
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }


}
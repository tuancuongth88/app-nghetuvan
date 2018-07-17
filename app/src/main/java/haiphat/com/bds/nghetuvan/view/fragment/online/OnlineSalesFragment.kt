package haiphat.com.bds.nghetuvan.view.fragment.online

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.FragmentOnlineSalesBinding
import haiphat.com.bds.nghetuvan.utils.dialog.DialogSelectTableOfGoods
import haiphat.com.bds.nghetuvan.utils.dialog.ShowAlert
import haiphat.com.bds.nghetuvan.utils.dialog.ShowLoading
import haiphat.com.bds.nghetuvan.view.BaseFragment
import haiphat.com.bds.nghetuvan.view.home.HomeActivity
import android.widget.TableRow.LayoutParams;
import haiphat.com.bds.nghetuvan.view.online.DetailOnlineSalesActivity
import haiphat.com.bds.nghetuvan.viewmodel.onlineSales.OnlineSalesViewModel


class OnlineSalesFragment : BaseFragment() {

    private lateinit var dataBindingFragmentOnlineSales: FragmentOnlineSalesBinding
    private var onlineSalesViewModel = OnlineSalesViewModel()
    private var recyclableTextView: TextView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBindingFragmentOnlineSales = DataBindingUtil.inflate(inflater, R.layout.fragment_online_sales, container, false)
        context?.let {
            (activity as HomeActivity).setBackgroundColor(ContextCompat.getColor(it, R.color.colorPrimary))
        }

        dataBindingFragmentOnlineSales.rippleProject.setOnRippleCompleteListener {
            getProjectTableOfGoods()
        }
        dataBindingFragmentOnlineSales.rippleBuilding.setOnRippleCompleteListener {
            getBuildingTableOfGoods(onlineSalesViewModel.categoryId)
        }
        dataBindingFragmentOnlineSales.rippleSearch.setOnRippleCompleteListener {
            getTableGoods()
        }
        initView()
        return dataBindingFragmentOnlineSales.root
    }

    private fun initView(){
        val wrapWrapTableRowParams = TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        val fixedColumnWidths = intArrayOf(20, 20, 20, 20, 20)
        val scrollableColumnWidths = intArrayOf(20, 20, 20, 30, 30)
        val fixedRowHeight = 150
        val fixedHeaderHeight = 150

        var row = TableRow(context)
        //header (fixed vertically)
//        val header = findViewById(R.id.table_header) as TableLayout
        row.setLayoutParams(wrapWrapTableRowParams)
        row.setGravity(Gravity.CENTER)
        row.setBackgroundColor(Color.YELLOW)
        row.addView(makeTableRowWithText("can 1", fixedColumnWidths[0], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 2", fixedColumnWidths[1], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 3", fixedColumnWidths[2], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 4", fixedColumnWidths[3], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 5", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 6", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 7", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 8", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 9", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 10", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 11", fixedColumnWidths[0], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 12", fixedColumnWidths[1], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 13", fixedColumnWidths[2], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 14", fixedColumnWidths[3], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 15", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 16", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 17", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 18", fixedColumnWidths[4], fixedHeaderHeight))
        row.addView(makeTableRowWithText("can 19", fixedColumnWidths[4], fixedHeaderHeight))
//        row.addView(makeTableRowWithText("can 20", fixedColumnWidths[4], fixedHeaderHeight))
        dataBindingFragmentOnlineSales.scrollablePart.addView(row)
//        val fixedColumn = findViewById(R.id.fixed_column) as TableLayout
        //rest of the table (within a scroll view)
//        val scrollablePart = findViewById(R.id.scrollable_part) as TableLayout
        for (i in 1..21) {
            val fixedView = makeTableRowWithText("Tang " + i, scrollableColumnWidths[0], fixedRowHeight)
            fixedView.setBackgroundColor(Color.BLUE)
            dataBindingFragmentOnlineSales.fixedColumn.addView(fixedView)
            row = TableRow(context)
            row.setLayoutParams(wrapWrapTableRowParams)
            row.setGravity(Gravity.CENTER)
            row.setBackgroundColor(Color.WHITE)
            row.addView(makeTableRowWithText("value 1", scrollableColumnWidths[1], fixedRowHeight))
            row.addView(makeTableRowWithText("value 2", scrollableColumnWidths[2], fixedRowHeight))
            row.addView(makeTableRowWithText("value 3", scrollableColumnWidths[3], fixedRowHeight))
            row.addView(makeTableRowWithText("value 4", scrollableColumnWidths[4], fixedRowHeight))
            row.addView(makeTableRowWithText("value 5", scrollableColumnWidths[1], fixedRowHeight))
            row.addView(makeTableRowWithText("value 6", scrollableColumnWidths[2], fixedRowHeight))
            row.addView(makeTableRowWithText("value 7", scrollableColumnWidths[3], fixedRowHeight))
            row.addView(makeTableRowWithText("value 8", scrollableColumnWidths[4], fixedRowHeight))
            row.addView(makeTableRowWithText("value 9", scrollableColumnWidths[1], fixedRowHeight))
            row.addView(makeTableRowWithText("value 10", scrollableColumnWidths[2], fixedRowHeight))
            row.addView(makeTableRowWithText("value 11", scrollableColumnWidths[3], fixedRowHeight))
            row.addView(makeTableRowWithText("value 12", scrollableColumnWidths[4], fixedRowHeight))
            row.addView(makeTableRowWithText("value 13", scrollableColumnWidths[1], fixedRowHeight))
            row.addView(makeTableRowWithText("value 14", scrollableColumnWidths[2], fixedRowHeight))
            row.addView(makeTableRowWithText("value 15", scrollableColumnWidths[3], fixedRowHeight))
            row.addView(makeTableRowWithText("value 16", scrollableColumnWidths[4], fixedRowHeight))
            row.addView(makeTableRowWithText("value 17", scrollableColumnWidths[4], fixedRowHeight))
            row.addView(makeTableRowWithText("value 18", scrollableColumnWidths[4], fixedRowHeight))
            row.addView(makeTableRowWithText("value 19", scrollableColumnWidths[4], fixedRowHeight))
//            row.addView(makeTableRowWithText("value 20", scrollableColumnWidths[4], fixedRowHeight))
            dataBindingFragmentOnlineSales.scrollablePart.addView(row)
        }
    }

    private fun makeTableRowWithText(text: String, widthInPercentOfScreenWidth: Int, fixedHeightInPixels: Int): TextView {
        val screenWidth = resources.displayMetrics.widthPixels
        recyclableTextView = TextView(context)
        recyclableTextView?.text = text
        recyclableTextView?.setTextColor(Color.BLACK)
        recyclableTextView?.setTextSize(20f)
        recyclableTextView?.width = widthInPercentOfScreenWidth * screenWidth / 100
        recyclableTextView?.height = fixedHeightInPixels
        recyclableTextView?.setOnClickListener {
            startActivity(Intent(activity, DetailOnlineSalesActivity::class.java))
        }
        return recyclableTextView as TextView
    }

    private fun getProjectTableOfGoods() {
        ShowLoading.show(context)
        onlineSalesViewModel.getProjectTableOfGoods(onSuccess = {
            DialogSelectTableOfGoods((activity as HomeActivity), it, onClick = {
                setTextProject(it?.name)
            }).show()
            ShowLoading.dismiss()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }

    private fun setTextProject(name: String?) {
        dataBindingFragmentOnlineSales.tvProject.text = name
    }

    private fun setTextBuilding(name: String?) {
        dataBindingFragmentOnlineSales.tvBuilding.text = name
    }

    private fun getBuildingTableOfGoods(id: Int?) {
        ShowLoading.show(context)
        onlineSalesViewModel.getBuildingTableOfGoods(projectId = id, onSuccess = {
            DialogSelectTableOfGoods((activity as HomeActivity), it, onClick = {
                setTextBuilding(it?.name)
            }).show()
            ShowLoading.dismiss()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }

    private fun getTableGoods() {
        ShowLoading.show(context)
        onlineSalesViewModel.getTableOfGoods(onSuccess = {
            ShowLoading.dismiss()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }
}
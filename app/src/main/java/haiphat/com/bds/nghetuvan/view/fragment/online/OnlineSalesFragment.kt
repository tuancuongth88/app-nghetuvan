package haiphat.com.bds.nghetuvan.view.fragment.online

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.Typeface
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
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        return dataBindingFragmentOnlineSales.root
    }



    @SuppressLint("ResourceType")
    private fun initView() {
        val wrapWrapTableRowParams = TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        val fixedColumnWidths = intArrayOf(20, 20, 20, 20, 20)
        val scrollableColumnWidths = intArrayOf(20, 20, 20, 30, 30)
        val fixedRowHeight = 150
        val fixedHeaderHeight = 150
        var row = TableRow(context)
        row.layoutParams = wrapWrapTableRowParams
        row.gravity = Gravity.CENTER
        row.setBackgroundColor(Color.parseColor("#f68121"))
        row.addView(makeTableRowWithText("can 1", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 2", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 3", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 4", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 5", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 6", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 7", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 8", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 9", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 10", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 11", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 12", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 13", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 14", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 15", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 16", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 17", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 18", fixedColumnWidths[1], fixedHeaderHeight, false))
        row.addView(makeTableRowWithText("can 19", fixedColumnWidths[1], fixedHeaderHeight, false))
        dataBindingFragmentOnlineSales.scrollablePart.addView(row)
        for (i in 1..21) {
            if (i == 1) {
                val fixedView = makeTableRowWithText("T/C", scrollableColumnWidths[0], fixedRowHeight, false)
                fixedView.setBackgroundColor(Color.parseColor("#a52d2d"))
                dataBindingFragmentOnlineSales.fixedColumn.addView(fixedView)
            } else {
                var count = i - 1
                val fixedView = makeTableRowWithText("Tầng " + count, scrollableColumnWidths[0], fixedRowHeight, false)
                fixedView.setBackgroundColor(Color.parseColor("#a52d2d"))
                dataBindingFragmentOnlineSales.fixedColumn.addView(fixedView)
            }
            row = TableRow(context)
            row.layoutParams = wrapWrapTableRowParams
            row.gravity = Gravity.CENTER
            row.setBackgroundColor(Color.WHITE)
            row.addView(makeTableRowWithText("101", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("102", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("103", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("104", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("105", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("106", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("107", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("108", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("109", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1010", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1011", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1012", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1013", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1014", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1015", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1016", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1017", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1018", scrollableColumnWidths[1], fixedRowHeight, true))
            row.addView(makeTableRowWithText("1019", scrollableColumnWidths[1], fixedRowHeight, true))
//            row.addView(makeTableRowWithText("1020", scrollableColumnWidths[4], fixedRowHeight))
            dataBindingFragmentOnlineSales.scrollablePart.addView(row)
        }
    }

    private fun makeTableRowWithText(text: String, widthInPercentOfScreenWidth: Int, fixedHeightInPixels: Int, type : Boolean): TextView {
        val screenWidth = resources.displayMetrics.widthPixels
        recyclableTextView = TextView(context)
        recyclableTextView?.text = text
        when(type){
            true ->{
                recyclableTextView?.setTextColor(Color.BLACK)
            }
            false ->{
                recyclableTextView?.setTextColor(Color.WHITE)
                recyclableTextView?.typeface = Typeface.DEFAULT_BOLD
            }
        }
        recyclableTextView?.textSize = 20f
        recyclableTextView?.width = widthInPercentOfScreenWidth * screenWidth / 100
        recyclableTextView?.height = fixedHeightInPixels
        recyclableTextView?.gravity = Gravity.CENTER
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
            initView()
        }, onFailed = {
            ShowAlert.fail(pContext = context, message = it)
            ShowLoading.dismiss()
        })
    }
}
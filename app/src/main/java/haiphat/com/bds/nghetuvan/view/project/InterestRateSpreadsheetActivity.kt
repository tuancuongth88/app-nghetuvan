package haiphat.com.bds.nghetuvan.view.project

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.adapter.project.InterestRateSpreadsheetAdapter
import haiphat.com.bds.nghetuvan.databinding.ActivityInterestRateSpreadsheetBinding
import haiphat.com.bds.nghetuvan.models.project.InterestRateSpreadsheetResponse
import haiphat.com.bds.nghetuvan.view.BaseActivity
import haiphat.com.bds.nghetuvan.viewmodel.project.ProjectPaymentViewModel

class InterestRateSpreadsheetActivity : BaseActivity() {

    private lateinit var dataBindingInterestRateSpreadsheet : ActivityInterestRateSpreadsheetBinding
    private var projectPaymentViewModel = ProjectPaymentViewModel()


    override fun getContentView(): View {
        dataBindingInterestRateSpreadsheet = DataBindingUtil.inflate(layoutInflater, R.layout.activity_interest_rate_spreadsheet, null, false)
        return dataBindingInterestRateSpreadsheet.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        setHeaderTitle("Tính lãi suất vay dự án")
        projectPaymentViewModel.getTableInterest()
        initAdapter(projectPaymentViewModel.list)
    }

    private fun initAdapter(list : ArrayList<InterestRateSpreadsheetResponse>?){
        val recyclerView = dataBindingInterestRateSpreadsheet.rvInterestRateSpreadsheet
        val adapter = InterestRateSpreadsheetAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this@InterestRateSpreadsheetActivity)
        recyclerView.adapter = adapter

    }
}

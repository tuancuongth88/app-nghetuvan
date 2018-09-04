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
import haiphat.com.bds.nghetuvan.models.project.InterestRateSpreadsheetResponse
import kotlinx.android.synthetic.main.item_table_interest_rate_spreadsheet.view.*

/**
 * Created by DEV-01 on 12/29/2017.
 */
class InterestRateSpreadsheetAdapter(private val list: ArrayList<InterestRateSpreadsheetResponse>?) : RecyclerView.Adapter<InterestRateSpreadsheetAdapter.InterestRateSpreadsheetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestRateSpreadsheetViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_table_interest_rate_spreadsheet, parent, false)
        return InterestRateSpreadsheetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InterestRateSpreadsheetViewHolder, position: Int) {
        holder?.bindItem(list?.get(position), position + 1)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    class InterestRateSpreadsheetViewHolder(itemView: ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindItem(interestRateSpreadsheetResponse: InterestRateSpreadsheetResponse?, position: Int) {
            itemView.tvSTT.text = position.toString()
            itemView.tvDate.text = interestRateSpreadsheetResponse?.payDay
            itemView.tvOriginalPay.text = interestRateSpreadsheetResponse?.originalPay?.toString()
            itemView.tvInterest.text = interestRateSpreadsheetResponse?.interest?.toString()
            itemView.tvRest.text = interestRateSpreadsheetResponse?.rest?.toString()
            itemView.tvTotal.text = interestRateSpreadsheetResponse?.total?.toString()
        }
    }
}
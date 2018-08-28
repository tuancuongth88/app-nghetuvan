package haiphat.com.bds.nghetuvan.view.project

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.ActivityProjectSetCalendarBinding
import haiphat.com.bds.nghetuvan.view.BaseActivity

class ProjectSetCalendarActivity : BaseActivity() {

    private lateinit var dataBingProjectSetCalendar : ActivityProjectSetCalendarBinding

    override fun getContentView(): View {
        dataBingProjectSetCalendar = DataBindingUtil.inflate(layoutInflater, R.layout.activity_project_set_calendar, null, false)
        return dataBingProjectSetCalendar.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHeaderBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        setHeaderTitle("Đặt lịch tham quan nhà mẫu")
    }
}

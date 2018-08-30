package haiphat.com.bds.nghetuvan.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.EditText
import android.widget.TextView
import com.makeramen.roundedimageview.RoundedImageView
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.models.auth.UserResponse
import haiphat.com.bds.nghetuvan.models.home.HomePageCategoryType
import haiphat.com.bds.nghetuvan.utils.extensions.fromUrl
import haiphat.com.bds.nghetuvan.viewmodel.profiles.ProfileViewModel
import java.text.SimpleDateFormat
import java.util.*


class CommonUtil {

    companion object {
        fun toCategoryType(courseType: Int?): HomePageCategoryType {
            var ret = HomePageCategoryType.Undefined
            HomePageCategoryType.values().forEach {
                if (courseType == it.type) {
                    ret = it
                }
            }
            return ret
        }

        fun requestPermissionGrantResults(grantResults: IntArray): Boolean {
            var ret = true
            grantResults.forEach {
                ret = ret && (it == PackageManager.PERMISSION_GRANTED)
            }
            return ret
        }

        fun shareAppLinkViaFacebook(activity : Activity, urlToShare: String) {
            val share = Intent(android.content.Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, urlToShare)
            activity.startActivity(share)
        }

        fun getProfile(rivAvatar: RoundedImageView, tvName : TextView, tvEmail: TextView){
            ProfileViewModel().getProfile(onSuccess = {
                rivAvatar.fromUrl(it?.avatar, placeHolder = R.drawable.ic_menu_user)
                tvName.text = it?.fullname
                tvEmail.text = it?.email
            }, onFailed = {})
        }

        fun setDataUploadAvatar(rivAvatar: RoundedImageView, tvName : TextView, tvEmail: TextView, userResponse: UserResponse?){
            rivAvatar.fromUrl(userResponse?.avatar, placeHolder = R.drawable.ic_defaut_avatar)
            tvName.text = userResponse?.fullname
            tvEmail.text = userResponse?.email
        }

        fun showDatePickerDialog(activity: Activity?, editText: EditText?) {
            val newCalendar = Calendar.getInstance()
            var dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
            val fromDatePickerDialog = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val newDate = Calendar.getInstance()
                newDate.set(year, monthOfYear, dayOfMonth)
                editText?.setText(dateFormatter.format(newDate.time))
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH))
            fromDatePickerDialog.show()
        }

        fun showTimePickerDialog(activity: Activity, edTime : EditText?){
            var calendar = Calendar.getInstance()
            val timePickerDialog = TimePickerDialog(activity, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                edTime?.setText( hourOfDay.toString() + ":" + minute)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)
            timePickerDialog.show()

        }

    }
}
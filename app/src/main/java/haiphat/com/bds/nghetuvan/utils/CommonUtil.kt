package haiphat.com.bds.nghetuvan.utils

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import haiphat.com.bds.nghetuvan.models.HomePageCategoryType


/**
 * Created by HUONG HA^P on 3/29/2018.
 */
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
    }
}
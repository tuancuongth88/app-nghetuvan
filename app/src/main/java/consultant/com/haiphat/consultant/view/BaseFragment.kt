package consultant.com.haiphat.consultant.view

import android.support.v4.app.Fragment

/**
 * Created by HUONG HA^P on 3/27/2018.
 */
abstract class BaseFragment : Fragment(){
    open fun onSearchClick(searchQuery: String) {

    }

    open fun onBackPressed():Boolean {
        return false
    }
}
package haiphat.com.bds.nghetuvan.view

import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment(){
    open fun onSearchClick(searchQuery: String) {

    }

    open fun onBackPressed():Boolean {
        return false
    }
}
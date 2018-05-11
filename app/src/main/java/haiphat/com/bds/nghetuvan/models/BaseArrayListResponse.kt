package haiphat.com.bds.nghetuvan.models

/**
 * Created by HUONG HA^P on 5/5/2018.
 */
open class BaseArrayListResponse<T> {
    var status: Boolean? = null
    var data: ArrayList<T>? = null
    var message: String? = null
}
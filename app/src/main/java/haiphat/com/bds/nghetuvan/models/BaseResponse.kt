package haiphat.com.bds.nghetuvan.models

/**
 * Created by HUONG HA^P on 4/7/2018.
 */
class BaseResponse<T> {

    var status : Boolean? = null
    var data : ArrayList<T>? = null
    var message : String? =null
}
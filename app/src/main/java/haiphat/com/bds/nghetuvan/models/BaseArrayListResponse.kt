package haiphat.com.bds.nghetuvan.models

open class BaseArrayListResponse<T> {
    var status: Boolean? = null
    var data: ArrayList<T>? = null
    var message: String? = null
}
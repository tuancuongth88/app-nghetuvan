package haiphat.com.bds.nghetuvan.models.online

/**
 * Created by sivan on 7/19/2018.
 */
data class PayResponse (
        var id : String? = null,
        var fullName : String? = null,
        var address : String? = null,
        var idNumber : String? =null,
        var email : String? =null,
        var price : String? = null,
        var type : PayType? = PayType.Undefined
)
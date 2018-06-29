package haiphat.com.bds.nghetuvan.models.education

/**
 * Created by sivan on 6/29/2018.
 */
data class ItemEducationResponse(
        var id : String? = null,
        var title : String? = null,
        var description : String? = null,
        var fullName : String?= null,
        var phone : String? = null,
        var email : String? = null,
        var item : ArrayList<String>? =null,
        var time : String? = null,
        var address : String? = null,
        var url : String? = null
)
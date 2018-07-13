package haiphat.com.bds.nghetuvan.models.online

/**
 * Created by sivan on 7/13/2018.
 */
data class TypeTableOfGoodsResponse(
        var id  :String ? = null,
        var name : String ? = null,
        var data : ArrayList<BuildingResponse> ?= null
)
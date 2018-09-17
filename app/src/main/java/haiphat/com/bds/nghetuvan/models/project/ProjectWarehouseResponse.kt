package haiphat.com.bds.nghetuvan.models.project

import haiphat.com.bds.nghetuvan.models.BaseResponse

/**
 * Created by HUONG HA^P on 5/17/2018.
 */
data class ProjectWarehouseResponse (
        var description : String? = null,
        var latitude : Double ?= null,
        var longitude : Double ?= null,
        var image_url : ArrayList<String> ?= null,
        var min_price : String ?= null,
        var max_price : String ?= null,
        var address : String ?= null,
        var time_out : String ?= null,
        var city : CityResponse ?= null,
        var type : TypeResponse ?= null,
        var kind : KindResponse ?= null

):BaseResponse()


class CityResponse{
    var city_id : String ?= null
    var name : String ?= null
}
class TypeResponse{
    var value : String ?= null
    var description : String ?= null
}
class KindResponse{
    var value : String ?= null
    var description : String ?= null
}
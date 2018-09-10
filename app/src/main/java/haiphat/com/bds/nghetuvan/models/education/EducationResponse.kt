package haiphat.com.bds.nghetuvan.models.education

import haiphat.com.bds.nghetuvan.models.BaseResponse

/**
 * Created by sivan on 6/29/2018.
 */
data class EducationResponse(
        var target : String?= null,
        var open_time : String ?= null,
        var close_time : String ?= null,
        var schedule : String ?= null,
        var school_time : String ?= null,
        var total_time : String ?= null,
        var total_fee : String ?= null,
        var fee_discount : String ?= null,
        var description : String? = null,
        var message : String? = null,
        var fullName : String?= null,
        var phone : String? = null,
        var email : String? = null,
        var url : String? = null
): BaseResponse()
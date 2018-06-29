package haiphat.com.bds.nghetuvan.models.education

import haiphat.com.bds.nghetuvan.models.home.HomePageResponse

/**
 * Created by sivan on 6/28/2018.
 */
data class EducationResponse (
    var id: String? = null,
    var name: String? = null,
    var data : ArrayList<HomePageResponse>? = null
)
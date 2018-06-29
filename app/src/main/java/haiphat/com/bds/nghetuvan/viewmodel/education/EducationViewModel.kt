package haiphat.com.bds.nghetuvan.viewmodel.education

import haiphat.com.bds.nghetuvan.models.education.EducationResponse

/**
 * Created by sivan on 6/28/2018.
 */
class EducationViewModel {

    fun getItemEducation(onSuccess : ()->Unit?, onFailed : (String?) -> Unit?){
        onSuccess()
    }
    fun getFormRegisterEducation(onSuccess : ()->Unit?, onFailed : (String?) -> Unit?){
        onSuccess()
    }

    private fun mockDataItemEducation() : ArrayList<EducationResponse>{
        var list = ArrayList<EducationResponse>()

        return list
    }

}
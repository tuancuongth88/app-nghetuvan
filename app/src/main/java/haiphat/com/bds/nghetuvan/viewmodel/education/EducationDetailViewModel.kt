package haiphat.com.bds.nghetuvan.viewmodel.education

import haiphat.com.bds.nghetuvan.models.education.ItemEducationResponse

class EducationDetailViewModel {

    private var content : String = "Just like Android, Kotlin is an open source project under Apache 2.0. Our choice of Kotlin reaffirms our commitment to an open developer ecosystem as we evolve and grow the Android platform, and we are excited to see the language evolve."

    fun getInfoEducation(onSuccess : (String)->Unit?, onFailed : (String?) -> Unit?){
        onSuccess(content)
    }

    fun getFormRegisterEducation(onSuccess : (ItemEducationResponse)->Unit?, onFailed : (String?) -> Unit?){
        onSuccess(mockFormDataEducation())
    }

    fun submitFormEducation(onSuccess : ()->Unit?, onFailed : (String?) -> Unit?){
        onSuccess()
    }

    private fun mockFormDataEducation(): ItemEducationResponse {
        val item = ArrayList<String>()
        item.add("dap an A")
        item.add("dap an B")
        item.add("dap an C")
        item.add("dap an D")
        return ItemEducationResponse(title = "Quan ly kinh doanh", description = "Kotlin is now an official language on Android. It's expressive, concise, and powerful. Best of all, it's interoperable with our existing Android languages and runtime.", item = item)
    }
}
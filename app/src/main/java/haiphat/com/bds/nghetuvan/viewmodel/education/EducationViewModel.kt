package haiphat.com.bds.nghetuvan.viewmodel.education

import haiphat.com.bds.nghetuvan.models.education.EducationResponse
import haiphat.com.bds.nghetuvan.models.education.ItemEducationResponse

/**
 * Created by sivan on 6/28/2018.
 */
class EducationViewModel {

    fun getCategoryEducation(onSuccess : (ArrayList<EducationResponse>)->Unit?, onFailed : (String?) -> Unit?){
        onSuccess(mockDataCategoryEducation())
    }

    fun getItemEducation(onSuccess : (ArrayList<ItemEducationResponse>)->Unit?, onFailed : (String?) -> Unit?){
        onSuccess(mockDataItemEducation())
    }
    private fun mockDataCategoryEducation() : ArrayList<EducationResponse>{
        var list = ArrayList<EducationResponse>()
        list.add(EducationResponse(name = "Quản trị kinh doanh khách sạn"))
        list.add(EducationResponse(name = "Quản trị dịch vụ bất động sản"))
        list.add(EducationResponse(name = "Quản trị tài chính" ))
        list.add(EducationResponse(name = "Quản trị nhân sự" ))
        list.add(EducationResponse(name = "Quản trị đầu tư chứng khoán" ))
        return list
    }


    private fun mockDataItemEducation() : ArrayList<ItemEducationResponse>{
        var itemList = ArrayList<ItemEducationResponse>()
        itemList.add(ItemEducationResponse(title = "Kỹ năng phỏng vấn tuyển dụng", time = "15-10-2018", address = "tòa nhà the price", url = ""))
        itemList.add(ItemEducationResponse(title = "Phần tích thẩm định dự án đầu tư", time = "15-10-2018", address = "tòa nhà the price", url = ""))
        itemList.add(ItemEducationResponse(title = "Đầu tư tài chính", time = "15-10-2018", address = "tòa nhà the price", url = ""))
        itemList.add(ItemEducationResponse(title = "Quản trị tài chính dự án", time = "15-10-2018", address = "tòa nhà the price", url = ""))
        itemList.add(ItemEducationResponse(title = "Kỹ năng bán hàng chuyên nghiệp", time = "15-10-2018", address = "tòa nhà the price", url = ""))
        return itemList
    }
}
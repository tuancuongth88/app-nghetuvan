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
    fun getFormRegisterEducation(onSuccess : (ItemEducationResponse)->Unit?, onFailed : (String?) -> Unit?){
        onSuccess(mockFormDataEducation())
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

    private fun mockDataEducation() : ArrayList<EducationResponse>{
        var list = ArrayList<EducationResponse>()
        list.add(EducationResponse(name = "QUẢN TRỊ KINH DOANH BẤT ĐỘNG SẢN", data = mockDataItemEducation()))
        list.add(EducationResponse(name = "QUẢN TRỊ KINH DOANH KHÁCH SẠN", data = mockDataItemEducation()))
        list.add(EducationResponse(name = "QUẢN TRỊ DỊCH VỤ BẤT ĐỘNG SẢN", data = mockDataItemEducation()))
        list.add(EducationResponse(name = "QUẢN TRỊ TÀI CHÍNH", data = mockDataItemEducation()))
        list.add(EducationResponse(name = "QUẢN TRỊ NHÂN SỰ", data = mockDataItemEducation()))
        list.add(EducationResponse(name = "QUẢN TRỊ ĐẦU TƯ CHỨNG KHOÁN", data = mockDataItemEducation()))
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

    private fun mockFormDataEducation(): ItemEducationResponse{
        var item = ArrayList<String>()
        item.add("dap an A")
        item.add("dap an B")
        item.add("dap an C")
        item.add("dap an D")
        return ItemEducationResponse(time = "", description = "", item = item)
    }
}
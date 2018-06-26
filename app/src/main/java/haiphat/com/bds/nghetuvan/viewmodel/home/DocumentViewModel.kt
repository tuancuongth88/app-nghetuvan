package haiphat.com.bds.nghetuvan.viewmodel.home

import haiphat.com.bds.nghetuvan.models.home.HomeCategoryResponse

/**
 * Created by HUONG HA^P on 6/26/2018.
 */
class DocumentViewModel {

    fun getItemDocument(onSuccess : (ArrayList<HomeCategoryResponse>) ->Unit, onFailed : (String?) -> Unit) {
        onSuccess(mockItemDocument())
    }


    private fun mockItemDocument() : ArrayList<HomeCategoryResponse>{
        var listData = ArrayList<HomeCategoryResponse>()
        listData.add(HomeCategoryResponse(id = "1", name = "Kho dự án"))
        listData.add(HomeCategoryResponse(id = "2", name = "Bán hàng online"))
        listData.add(HomeCategoryResponse(id = "3", name = "dự án"))
        return listData
    }
}
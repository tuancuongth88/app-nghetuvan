package haiphat.com.bds.nghetuvan.viewmodel.option

import haiphat.com.bds.nghetuvan.models.option.OptionList
import haiphat.com.bds.nghetuvan.services.GsonUtil
import haiphat.com.bds.nghetuvan.services.api.option.CitiesApi

/**
 * Created by sivan on 8/10/2018.
 */
class OptionViewModel {

    fun getCity(onSuccess : (OptionList) ->Unit, onFailed : (String?) -> Unit){
        CitiesApi().getCities(onResponse = {
            var response = GsonUtil.fromJson(it.responseContent, OptionList::class.java)
            if (it.status == 200){
                response?.data.let {

                }
            }else{
                onFailed(it.getErrorMessage())
            }
        })
    }
}
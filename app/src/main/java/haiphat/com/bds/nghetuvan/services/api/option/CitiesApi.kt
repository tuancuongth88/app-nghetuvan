package haiphat.com.bds.nghetuvan.services.api.option

import haiphat.com.bds.nghetuvan.services.Config
import haiphat.com.bds.nghetuvan.services.DgmResponse
import haiphat.com.bds.nghetuvan.services.api.BaseApi

/**
 * Created by sivan on 8/10/2018.
 */
class CitiesApi : BaseApi() {
    override fun apiUrl(): String? {
        return "option/"
    }

    override fun getEndPoint(): String? {
        return Config.API_URL
    }

    fun getCities(onResponse: (DgmResponse) -> Unit) {
        this["get-CitiesApi", onResponse]
    }
}
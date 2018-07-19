package haiphat.com.bds.nghetuvan.viewmodel.onlineSales

import haiphat.com.bds.nghetuvan.models.online.PayResponse
import haiphat.com.bds.nghetuvan.models.online.PayType
import haiphat.com.bds.nghetuvan.models.online.TypeTableOfGoodsResponse
import haiphat.com.bds.nghetuvan.models.online.convertPayType

/**
 * Created by sivan on 7/19/2018.
 */
class PayViewModel  {

    fun sendRequire(onSuccess: (PayResponse) -> Unit, onFailed: (String?) -> Unit) {
        onSuccess(mockDataSendRequire())
    }

    fun mockDataSendRequire() : PayResponse {
        var payResponse = PayResponse()
        payResponse.fullName = "Nguyen van si"
        payResponse.address = "122 hoang cau"
        payResponse.idNumber = "112419761"
        payResponse.email = "si@gmail.com"
        payResponse.price = "10.000.000"
        payResponse.type = PayType.PaymentGateways
        return payResponse
    }

}
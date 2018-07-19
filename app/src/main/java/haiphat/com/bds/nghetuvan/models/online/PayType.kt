package haiphat.com.bds.nghetuvan.models.online

/**
 * Created by sivan on 7/19/2018.
 */
enum class PayType(var type : Int) {
    Undefined(0),
    TradingAtTheFloor(1),
    Transfer(2),
    PaymentGateways(3),
}

fun PayType.convertPayType() : String{
    var str = ""
    when(this.type){
        PayType.Undefined.type -> {
            str = "Chọn loại thanh toán"
        }
        PayType.TradingAtTheFloor.type -> {
            str = "Thanh toán tại sàn"
        }
        PayType.Transfer.type -> {
            str = "Chuyển khoản"
        }
        PayType.PaymentGateways.type -> {
            str = "Cổng thoanh toán"
        }
    }
    return str
}
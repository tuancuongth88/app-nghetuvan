package haiphat.com.bds.nghetuvan.utils.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso
import haiphat.com.bds.nghetuvan.services.Config

/**
 * Created by HUONG HA^P on 3/28/2018.
 */
fun ImageView.fromUrl(url: String?, placeHolder: Int? = null) {
    var request = Picasso.with(this.context).load(Config.API_URL_OAUTH + url)
    placeHolder?.let {
        request = request.placeholder(it)
    }
    request.fit()
            .centerCrop()
            .into(this)
}

fun ImageView.fromUrlFixData(url: String?, placeHolder: Int? = null) {
    var request = Picasso.with(this.context).load(url)
    placeHolder?.let {
        request = request.placeholder(it)
    }
    request.fit()
            .centerCrop()
            .into(this)
}
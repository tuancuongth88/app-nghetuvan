package haiphat.com.bds.nghetuvan.services

import com.google.gson.Gson

/**
 * Created by DEV-01 on 12/19/2017.
 */
class GsonUtil {

    companion object {
        fun <T> fromJson(json: String?, returnType: Class<T>): T? {
            var ret: T? = null
            val gson = Gson()
            if (json != null) {
                try {
                    ret = gson.fromJson(json, returnType)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }

            }
            return ret
        }

        /**
         * create json string from an object
         * @param pObject
         * @return
         */
        fun toJson(pObject: Any): String? {
            var ret: String? = null
            val gson = Gson()
            try {
                ret = gson.toJson(pObject)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

            return ret
        }
    }

}
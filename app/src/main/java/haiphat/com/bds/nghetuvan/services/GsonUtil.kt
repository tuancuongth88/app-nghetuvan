package haiphat.com.bds.nghetuvan.services

import com.google.gson.Gson

class GsonUtil {

    companion object {

        fun <T> fromJson(json: String?, returnType: Class<T>): T? {
            var ret: T? = null
            if (json != null) {
                try {
                    ret = Gson().fromJson(json, returnType)
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
            try {
                ret = Gson().toJson(pObject)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

            return ret
        }
    }

}
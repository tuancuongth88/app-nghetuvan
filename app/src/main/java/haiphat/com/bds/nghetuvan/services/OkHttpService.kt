package haiphat.com.bds.nghetuvan.services

import android.os.Handler
import android.os.Looper
import android.util.Log
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by DEV-01 on 12/25/2017.
 */
object OkHttpService {

    private var okHttpClient: OkHttpClient? = null
    init {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(OAuthInterceptor)
        builder.connectTimeout(1, TimeUnit.MINUTES)
        okHttpClient = builder.build()
    }

    fun request(url: String, method: Method, pRequestBody: RequestBody?, headerBuilder: Headers.Builder?, completed: (DgmResponse)->Unit) {
        val builder = Request.Builder()
        when (method) {
            Method.GET -> {
            }
            Method.POST -> builder.post(pRequestBody)
            Method.DELETE -> builder.delete(pRequestBody)
            Method.PUT -> builder.put(pRequestBody)
        }
        builder.url(url)
        if (headerBuilder != null) {
            builder.headers(headerBuilder.build())
        }
        Log.d("dmg: ", "url: " + url)
        request(builder.build(), completed)
    }

    fun request(url: String, method: Method, pRequestBody: RequestBody, headerBuilder: Headers.Builder): DgmResponse {
        val builder = Request.Builder()
        when (method) {
            Method.GET -> {
            }
            Method.POST -> builder.post(pRequestBody)
            Method.DELETE -> builder.delete(pRequestBody)
            Method.PUT -> builder.put(pRequestBody)
        }
        Log.d("dmg: ", "url: " + url)
        builder.url(url)
        builder.headers(headerBuilder.build())
        try {
            val response = request(builder.build())
            return DgmResponse(response)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return DgmResponse(ex)
        }

    }

    private fun request(request: Request, completed : (DgmResponse) ->Unit) {
        okHttpClient?.newCall(request)?.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                val dgmResponse = DgmResponse(e)
                Handler(Looper.getMainLooper()).post {
                    completed(dgmResponse)
                }
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val dgmResponse = DgmResponse(response)
                Handler(Looper.getMainLooper()).post {
                    completed(dgmResponse)
                }

            }
        })
    }

    @Throws(Exception::class)
    private fun request(request: Request): Response? {
        return okHttpClient?.newCall(request)?.execute()
    }

    fun release() {
        okHttpClient = null
    }

    enum class Method {
        POST, GET, PUT, DELETE
    }

   object OAuthInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()

            //Build new request
            val builder = request.newBuilder()
            //            builder.header("Accept", "application/json"); //if necessary, say to consume JSON
            val token = "TOKEN"
            token?.let {
                setAuthHeader(builder, token) //write current token to request
            }

            request = builder.build() //overwrite old request
            val response = chain.proceed(request) //perform request, here original request will be executed
            if (response.code() == 401) { //if unauthorized
//                TODO: code == 401 show screen login
                okHttpClient?.let {
                    synchronized(it) {
                        //perform all 401 in sync blocks, to avoid multiply token updates
                        val currentToken = "TOKEN" //get currently stored token
                        if (currentToken != null && currentToken == token) { //compare current token with token that was stored before, if it was not updated - do update
//                            val dgmResponse = AuthApi().refreshTokenSynchronous(UserServices.refreshToken)
//                            if (dgmResponse?.isSuccess() ?: false){
//                                UserServices.logout()
//                                return response
//                            }
//                            if (dgmResponse?.hasNetwordError()!!) {
//                                return response
//                            }
                        }
//                        UserServices.accessToken?.let {
//                            setAuthHeader(builder, it) //set auth token to updated
//                            request = builder.build()
//                            return chain.proceed(request)
//                        }
                    }
                }
//                UserServices.logout()
            }
            return response
        }

        private fun setAuthHeader(builder: Request.Builder, token: String?) {
            token?.let {
                builder.header("Authorization", String.format("Bearer %s", token))
            }
        }
   }
}
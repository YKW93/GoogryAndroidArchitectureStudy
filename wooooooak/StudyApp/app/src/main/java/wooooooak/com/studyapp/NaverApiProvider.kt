package wooooooak.com.studyapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import wooooooak.com.studyapp.api.NaverRequestApi

val naverApi: NaverRequestApi
    get() = Retrofit.Builder()
        .baseUrl("https://openapi.naver.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(naverOkHttpClient)
        .build()
        .create(NaverRequestApi::class.java)

private val loggingInterceptor: HttpLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val headerInterceptor = Interceptor { chain ->
    val originRequest = chain.request()
    val request = originRequest
        .newBuilder()
        .addHeader("X-Naver-Client-Id", "bqoPQNNrQG37aim7xFBi")
        .addHeader("X-Naver-Client-Secret", "UyjnY7YFzC")
        .build()
    chain.proceed(request)
}

private val naverOkHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .addInterceptor(headerInterceptor)
    .build()

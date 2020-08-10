package team.moodup.kotlinstartproject.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import team.moodup.kotlinstartproject.BuildConfig
import team.moodup.kotlinstartproject.backend.ApiClient
import team.moodup.kotlinstartproject.backend.ApiClientInterface
import team.moodup.kotlinstartproject.backend.ApiService
import team.moodup.kotlinstartproject.managers.DataManager
import java.io.IOException
import java.util.concurrent.TimeUnit

val okHttpClientModule = module {

    single { createOkHttpClient(get()) }
}

val apiServiceModule = module {

    single {
        createWebService<ApiService>(get(), BuildConfig.BASE_URL)
    }
}

val apiClientModule = module {
    single { ApiClient(get(), get()) as ApiClientInterface }
}

val startProjectApi = listOf(okHttpClientModule, apiServiceModule, apiClientModule)

fun createOkHttpClient(dataManager: DataManager): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(dataManager))
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

internal class AuthInterceptor(val dataManager: DataManager) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val url: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("appid", BuildConfig.API_KEY)
            .build()

        val requestBuilder : Request.Builder = original.newBuilder()
            .url(url)
        val request : Request = requestBuilder.build()


//        addHeader("appid", BuildConfig.API_KEY).build()

        /*if (dataManager.isUserLoggedIn())
                   requestToProceed = request
                           .newBuilder()
                           .header("Authorization", "bearer " + dataManager.getAccessToken())
                           .build();*/

        return chain.proceed(request)
    }
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}




package team.moodup.kotlinstartproject.util

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import team.moodup.kotlinstartproject.backend.ApiService
import team.moodup.kotlinstartproject.modules.apiClientModule
import java.util.concurrent.Executor

val okHttpClientModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }
}

val apiMockServiceModule = module {
    single { MockWebServer() }
}

val apiServiceModule = module {
    single { createWebService<ApiService>(get(), get()) }
}

val testApiModules = listOf(apiMockServiceModule, okHttpClientModule, apiServiceModule, apiClientModule)


inline fun <reified T> createWebService(okHttpClient: OkHttpClient, server: MockWebServer): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(server.url("/").toString())
        .callbackExecutor(SynchronousExecutor())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}

class SynchronousExecutor : Executor {
    override fun execute(command: Runnable) {
        command.run()
    }
}
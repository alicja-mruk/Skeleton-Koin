package team.moodup.kotlinstartproject

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import team.moodup.kotlinstartproject.modules.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(moduleList)
        }
    }
    private val moduleList = listOf(dataModule) + startProjectApi + startProjectApp
}
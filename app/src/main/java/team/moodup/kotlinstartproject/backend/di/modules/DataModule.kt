package team.moodup.kotlinstartproject.backend.di.modules

import org.koin.dsl.module
import team.moodup.kotlinstartproject.backend.managers.DataManager

val dataModule = module{
    single { DataManager() }
}
package team.moodup.kotlinstartproject.modules

import org.koin.dsl.module
import team.moodup.kotlinstartproject.managers.DataManager

val dataModule = module{

    single { DataManager() }
}
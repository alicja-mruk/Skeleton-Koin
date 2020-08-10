package team.moodup.kotlinstartproject.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import team.moodup.kotlinstartproject.viewmodels.WeatherViewModel

val viewModelModules = module {
    viewModel {
        WeatherViewModel(get())
    }
}

val startProjectApp = listOf(viewModelModules)
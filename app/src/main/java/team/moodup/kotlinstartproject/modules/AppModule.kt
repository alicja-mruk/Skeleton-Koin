package team.moodup.kotlinstartproject.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.sampleapp.util.rx.ApplicationSchedulerProvider
import org.koin.sampleapp.util.rx.SchedulerProvider
import team.moodup.kotlinstartproject.backend.ApiClient
import team.moodup.kotlinstartproject.backend.ApiClientInterface
import team.moodup.kotlinstartproject.viewmodels.BaseViewModel
import team.moodup.kotlinstartproject.viewmodels.WeatherViewModel

val viewModelModules = module {
    viewModel<BaseViewModel> {
        WeatherViewModel(get())
    }
}


val rxModule = module {
    single<SchedulerProvider> { ApplicationSchedulerProvider() }
}
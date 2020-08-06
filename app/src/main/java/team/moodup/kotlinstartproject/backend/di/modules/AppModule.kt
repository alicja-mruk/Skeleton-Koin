package team.moodup.kotlinstartproject.backend.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.sampleapp.util.rx.ApplicationSchedulerProvider
import org.koin.sampleapp.util.rx.SchedulerProvider
import team.moodup.kotlinstartproject.viewmodels.WeatherViewModel

val viewModelModule = module {
    viewModel {
        WeatherViewModel(get())
    }
}

val rxModule = module {
     single{ApplicationSchedulerProvider() as SchedulerProvider}
}

val appModule = listOf(viewModelModule, rxModule)
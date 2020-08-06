package team.moodup.kotlinstartproject.util

import org.koin.dsl.module.module
import org.koin.sampleapp.util.TestSchedulerProvider
import org.koin.sampleapp.util.rx.SchedulerProvider

val testRxModule = module {

    single { TestSchedulerProvider() as SchedulerProvider }
}



val testApp = testRxModule
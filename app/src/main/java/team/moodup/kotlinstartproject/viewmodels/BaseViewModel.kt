package team.moodup.kotlinstartproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import team.moodup.kotlinstartproject.backend.repository.WeatherRepository

abstract class BaseViewModel(val api: WeatherRepository) : ViewModel() {

    val disposables = CompositeDisposable()

    fun launch(job: () -> Disposable) {
        disposables.add(job())
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
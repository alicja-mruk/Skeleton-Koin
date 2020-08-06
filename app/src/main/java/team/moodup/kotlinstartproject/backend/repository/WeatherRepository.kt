package team.moodup.kotlinstartproject.backend.repository

import io.reactivex.Single
import team.moodup.weatherapp.model.WeatherResult

interface WeatherRepository {
  fun getWeather(city : String) : Single<WeatherResult>
}
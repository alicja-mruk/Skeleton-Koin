package team.moodup.kotlinstartproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import team.moodup.kotlinstartproject.databinding.FragmentResultBinding
import team.moodup.kotlinstartproject.ui.fragments.WeatherFragment.Companion.WEATHER_KEY
import team.moodup.kotlinstartproject.model.WeatherResult
import team.moodup.kotlinstartproject.util.formatTimeToHours
import team.moodup.kotlinstartproject.util.getImageUrl


class ResultFragment : Fragment() {
    private lateinit var weather : WeatherResult
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weather = arguments?.get(WEATHER_KEY) as WeatherResult
        setDataIntoFields()
    }

    private fun setDataIntoFields(){
        binding.weatherImage.load(getImageUrl(weather.weather[0].icon))
        binding.cityField.text = weather.name
        binding.descriptionField.text = weather.weather[0].description
        binding.tempFieldMin.text  = weather.main.temp_max.toString()
        binding.tempFieldMax.text = weather.main.temp_min.toString()
        binding.windSpeedField.text = weather.wind.toString()
        binding.sunriseField.text = formatTimeToHours(weather.sys.sunrise.toLong())
        binding.sunsetField.text = formatTimeToHours(weather.sys.sunset.toLong())
    }

}
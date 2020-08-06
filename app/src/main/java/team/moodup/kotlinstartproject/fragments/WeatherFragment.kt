package team.moodup.kotlinstartproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.moodup.kotlinstartproject.R
import team.moodup.kotlinstartproject.databinding.FragmentWeatherBinding
import team.moodup.kotlinstartproject.viewmodels.WeatherViewModel

class WeatherFragment : BaseFragment() {
    private lateinit var binding: FragmentWeatherBinding
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setOnClickListeners()
        observeLiveData()
    }

    private fun setOnClickListeners() {
        binding.searchWeatherBtn.setOnClickListener {
            val cityText = binding.cityName.text.toString()
            if (cityText.isNotEmpty()) {
                viewModel.getWeather(cityText)
            } else {
                context?.resources?.getString(R.string.empty_city)
                    ?.let { it1 -> makeShortToast(it1) }
            }

        }
    }

    private fun observeLiveData() {
//        viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer {
//            Log.d("Weather", it.toString())
//        })
    }
}
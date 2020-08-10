package team.moodup.kotlinstartproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.moodup.kotlinstartproject.R
import team.moodup.kotlinstartproject.databinding.FragmentWeatherBinding
import team.moodup.kotlinstartproject.state.State
import team.moodup.kotlinstartproject.viewmodels.WeatherViewModel

class WeatherFragment : BaseFragment() {
    private lateinit var bundle: Bundle
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
            getWeather(cityText)
        }
    }

    private fun getWeather(cityText: String) {

        if (cityText.isNotEmpty()) {
            viewModel.getWeather(cityText)


        } else {
            context?.resources?.getString(R.string.empty_city)
                ?.let { it1 -> makeShortToast(it1) }
        }
    }
    private fun observeLiveData(){
        viewModel.stateLiveData.observe(viewLifecycleOwner, Observer { state->
            when(state){
                State.LOADING ->{
                    showProgressBar()
                }
                State.ON_ERROR->{
                    hideProgressBar()
                    context?.resources?.getString(R.string.error)?.let { toast(it) }
                }

                State.ON_RESULT->{
                    hideProgressBar()
                    val bundle = Bundle()
                    bundle.putParcelable(WEATHER_KEY, viewModel.weatherLiveData.value)
                    findNavController().navigate(R.id.action_weatherMainFragment_to_resultFragment, bundle)
                }
                else ->{

                }
            }
        })
    }

    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        binding.progressBar.visibility = View.GONE
    }

    private fun toast(message  :String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    companion object{
        const val WEATHER_KEY : String = "WEATHER_KEY"
    }
}
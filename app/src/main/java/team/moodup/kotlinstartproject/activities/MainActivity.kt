package team.moodup.kotlinstartproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.moodup.kotlinstartproject.databinding.ActivityMainBinding
import team.moodup.kotlinstartproject.viewmodels.WeatherViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

    }
}

package team.moodup.kotlinstartproject.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import team.moodup.kotlinstartproject.databinding.ActivityMainBinding

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
    }
}

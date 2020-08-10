package team.moodup.kotlinstartproject.util

import java.util.concurrent.TimeUnit

fun formatTimeToHours(time : Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(time).toInt() % 24
    val minutes = TimeUnit.MILLISECONDS.toMinutes(time).toInt() % 60
    val seconds = TimeUnit.MILLISECONDS.toSeconds(time).toInt() % 60
    return when {
        hours > 0 -> String.format("%d:%02d:%02d", hours, minutes, seconds)
        minutes > 0 -> String.format("%02d:%02d", minutes, seconds)
        seconds > 0 -> String.format("00:%02d", seconds)
        else -> {
            "00:00"
        }
    }
}

fun getImageUrl(iconCode : String): String {
    return "$IMAGE_URL$iconCode@2x.png"
}

const val IMAGE_URL = "http://openweathermap.org/img/wn/"
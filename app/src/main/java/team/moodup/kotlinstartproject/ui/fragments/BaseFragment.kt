package team.moodup.kotlinstartproject.ui.fragments

import androidx.fragment.app.Fragment
import android.widget.Toast

abstract class BaseFragment : Fragment() {

     fun makeShortToast(message : String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun makeLongToast(message : String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
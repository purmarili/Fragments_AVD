package ge.jvash.fragments_avd.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ge.jvash.fragments_avd.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var editText: EditText
    private lateinit var button: Button

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.button)
        editText = view.findViewById(R.id.editTextAmount)

        navController = Navigation.findNavController(view)

        button.setOnClickListener {
            var amount = -1
            if (editText.text.isNotEmpty()) {
                amount = editText.text.toString().toInt()
            }

            val action = HomeFragmentDirections.actionHomeFragmentToDashboardFragment(amount)
            navController.navigate(action)
        }

    }
}
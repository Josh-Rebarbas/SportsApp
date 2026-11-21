package com.example.sportsapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MySportsFragment : Fragment(R.layout.fragment_my_sports) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav = findNavController()
        view.findViewById<View>(R.id.btn_football).setOnClickListener {
            nav.navigate(R.id.action_mySports_to_football)
        }
        view.findViewById<View>(R.id.btn_basketball).setOnClickListener {
            nav.navigate(R.id.action_mySports_to_basketball)
        }
        view.findViewById<View>(R.id.btn_tennis).setOnClickListener {
            nav.navigate(R.id.action_mySports_to_tennis)
        }
    }
}

package com.up.cleanarchitecture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.up.cleanarchitecture.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

import kotlinx.android.synthetic.main.fragment_second2.*
class Second2Fragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        val species = arguments?.getString("species")
        val gender = arguments?.getString("gender")
        val status = arguments?.getString("status")

        name1.text = "Name: $name"
        status1.text = "Status: $status"
        gender1.text = "Gender: $gender"
        species1.text = "Species: $species"


    }
}
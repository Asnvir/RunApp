package com.example.runapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.runapp.R
import com.example.runapp.databinding.FragmentSettingsBinding
import com.example.runapp.other.Constants
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadFieldsFromSharedPref()

        binding.btnApplyChanges.setOnClickListener{
            val success = applyChangesToSharedPref()
            if(success) {
                Snackbar.make(view, "Saved changes", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Please fill out all the fields", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun loadFieldsFromSharedPref() {
        val name = sharedPref.getString(Constants.KEY_NAME, "")
        val weight = sharedPref.getFloat(Constants.KEY_WEIGHT, 80f)

        binding.etName.setText(name)
        binding.etWeight.setText(weight.toString())
    }


    private fun applyChangesToSharedPref(): Boolean {
        val nameText = binding.etName.text.toString()
        val weightText = binding.etWeight.text.toString()

        if(nameText.isEmpty() || weightText.isEmpty()) {
            return false
        }

        sharedPref.edit()
            .putString(Constants.KEY_NAME, nameText)
            .putFloat(Constants.KEY_WEIGHT, weightText.toFloat())
            .apply()

        val toolbarText = "Let's go, $nameText!"
        val tvToolbarTitle = requireActivity().findViewById<View>(R.id.tvToolbarTitle) as TextView
        tvToolbarTitle.text = toolbarText
        return true
    }
}


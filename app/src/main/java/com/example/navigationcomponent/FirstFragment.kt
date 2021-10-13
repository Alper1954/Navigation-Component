package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigationcomponent.databinding.FragmentFirstBinding

class FirstFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textEdit = binding.editMessageForFragment2

        val button = binding.navigateToFrag2
        button.setOnClickListener {
            // Navigate using that action
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(mess = textEdit.text.toString())
            it.findNavController().navigate(action)
        }
    }
}
package com.example.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentFirstBinding
import com.example.navigationcomponent.databinding.FragmentSecondBinding


private const val MESS = "mess"

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var messid: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       //messid=arguments?.getString("mess")

        val safeArgs: SecondFragmentArgs by navArgs()
        messid = safeArgs.mess

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView = binding.messageFromFragment1
        textView.text = messid
        val button = binding.navigateToFrag3
        button.setOnClickListener {
            // Navigate using that action
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            //val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            //it.findNavController().navigate(action)
        }
    }
}
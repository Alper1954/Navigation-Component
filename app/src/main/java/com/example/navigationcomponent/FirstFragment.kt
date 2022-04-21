package com.example.navigationcomponent

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navigationcomponent.databinding.FragmentFirstBinding

class FirstFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        setHasOptionsMenu(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textEdit = binding.editMessageForFragment2

        val button = binding.navigateToFrag2
        button.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(mess = textEdit.text.toString())
            it.findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
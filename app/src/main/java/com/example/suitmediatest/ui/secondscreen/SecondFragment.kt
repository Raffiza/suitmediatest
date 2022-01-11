package com.example.suitmediatest.ui.secondscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateUI()

        with(binding){
            btnChooseUser.setOnClickListener {
                view.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
            toolbar.backBtn.setOnClickListener {
                view.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            }
        }

    }

    private fun populateUI(){
        val name = args.name
        binding.txtName.text = name
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
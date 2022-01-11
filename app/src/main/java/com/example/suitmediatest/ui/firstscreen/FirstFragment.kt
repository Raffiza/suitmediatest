package com.example.suitmediatest.ui.firstscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnCheck.setOnClickListener{
                val text = textfieldPalindrome.text.toString()
                checkPalindrome(text)
            }
            btnNext.setOnClickListener {
                navigatetoNextFragment()
            }
        }
    }

    private fun checkPalindrome(text : String){
        val originaltext = text.replace("\\s".toRegex(), "")
        val reversetext = originaltext.reversed()

        if (originaltext == reversetext) {
            Toast.makeText(context,"This text is a palindrome",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context,"This text is not a palindrome",Toast.LENGTH_SHORT).show()
        }
    }

    fun navigatetoNextFragment(){
        val name = binding.textfieldName.text.toString()
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
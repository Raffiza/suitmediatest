package com.example.suitmediatest.ui.firstscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.suitmediatest.R
import com.example.suitmediatest.data.Repository
import com.example.suitmediatest.databinding.FragmentFirstBinding
import com.example.suitmediatest.ui.MainViewModel
import com.example.suitmediatest.utils.MainViewModelFactory

class FirstFragment : Fragment() {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        val originaltext = text.replace("\\s".toRegex(), "").lowercase()
        val reversetext = originaltext.reversed()

        if (originaltext == reversetext) {
            Toast.makeText(context,"This text is a palindrome",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context,"This text is not a palindrome",Toast.LENGTH_SHORT).show()
        }
    }

    fun navigatetoNextFragment(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        val name = binding.textfieldName.text.toString()
        if(name!=""){
            viewModel.setName(name)
        }
        Navigation.findNavController(requireView()).navigate(R.id.action_firstFragment_to_secondFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
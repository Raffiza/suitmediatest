package com.example.suitmediatest.ui.secondscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.suitmediatest.R
import com.example.suitmediatest.data.Repository
import com.example.suitmediatest.databinding.FragmentSecondBinding
import com.example.suitmediatest.ui.MainViewModel
import com.example.suitmediatest.utils.MainViewModelFactory

class SecondFragment : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateUI()

        with(binding){
            toolbar.toolbarTitle.text = getString(R.string.second_string)

            btnChooseUser.setOnClickListener {
                view.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
            toolbar.backBtn.setOnClickListener {
                view.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            }
        }

    }

    private fun populateUI(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        val name = viewModel.getName()
        val selectedname = viewModel.getSelectedName()
        with(binding){
            txtName.text = name
            txtSelectedName.text = selectedname
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
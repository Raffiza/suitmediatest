package com.example.suitmediatest.ui.secondscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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

        initiateUI()

    }

    private fun initiateUI(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        val name = viewModel.getName()
        val selectedname = viewModel.getSelectedName()

        with(binding){
            txtName.text = name

            txtSelectedName.text = selectedname

            toolbar.toolbarTitle.text = getString(R.string.second_string)

            btnChooseUser.setOnClickListener {
                navigateToNextFragment()
            }
            toolbar.backBtn.setOnClickListener {
                navigateBack()
            }
        }
    }

    private fun navigateToNextFragment(){
        Navigation.findNavController(requireView()).navigate(R.id.action_secondFragment_to_thirdFragment)
    }

    private fun navigateBack(){
        Navigation.findNavController(requireView()).navigate(R.id.action_secondFragment_to_firstFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
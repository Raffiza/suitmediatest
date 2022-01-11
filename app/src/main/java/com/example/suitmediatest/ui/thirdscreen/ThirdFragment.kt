package com.example.suitmediatest.ui.thirdscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmediatest.R
import com.example.suitmediatest.data.Repository
import com.example.suitmediatest.data.model.Data
import com.example.suitmediatest.databinding.FragmentThirdBinding
import com.example.suitmediatest.ui.MainViewModel
import com.example.suitmediatest.utils.MainViewModelFactory
import java.util.*

class ThirdFragment : Fragment() ,Adapter.onItemClickListener{

    private var _binding : FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private var rvData : List<Data> = Collections.emptyList()

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initiateObserver()

        with(binding){
            toolbar.toolbarTitle.text = getString(R.string.third_screen)

            toolbar.backBtn.setOnClickListener {
                navigateBack()
            }
        }
    }

    private fun initiateObserver(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getData()

        viewModel.myResponse.observe(this, { response ->
            if(response.isSuccessful){
                binding.progress.visibility = View.GONE
                binding.rvUser.visibility = View.VISIBLE

                val data = response.body()?.data
                if(data!=null){
                    initiateUI(data)
                }
            }
            else{
                binding.progress.visibility = View.GONE
                binding.txtError.visibility = View.VISIBLE
            }
        })
    }

    private fun initiateUI(data : List<Data>){
        val adapter = Adapter(requireContext(),this)

        adapter.setData(data)
        rvData = adapter.getData()

        binding.run {
            rvUser.layoutManager = LinearLayoutManager(requireContext())
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter
        }
    }

    private fun navigateBack(){
        Navigation.findNavController(requireView()).navigate(R.id.action_thirdFragment_to_secondFragment)
    }


    override fun onItemclick(position: Int) {
        val selectedName = rvData[position].first_name + " " + rvData[position].last_name
        viewModel.setSelectedName(selectedName)
        Toast.makeText(requireContext(),"$selectedName dipilih",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
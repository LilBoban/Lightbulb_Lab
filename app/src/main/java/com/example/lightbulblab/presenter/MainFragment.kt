package com.example.lightbulblab.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lightbulblab.R
import com.example.lightbulblab.databinding.FragmentMainBinding
import com.example.lightbulblab.di.DaggerAppComponent
import com.example.lightbulblab.di.viewModel.ViewModelFactory
import com.example.lightbulblab.presenter.MainViewModel
import dev.androidbroadcast.vbpd.viewBinding
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        val component = DaggerAppComponent.create()
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOn.setOnClickListener {
            viewModel.toggleLamp(true)
        }
        binding.btnOff.setOnClickListener {
            viewModel.toggleLamp(false)
        }
        binding.btnColorRed.setOnClickListener {
            viewModel.changeColor("red")
        }
        binding.btnColorGreen.setOnClickListener {
            viewModel.changeColor("green")
        }
        viewModel.statusMessage.observe(viewLifecycleOwner){
            message ->
            Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
        }
    }
}

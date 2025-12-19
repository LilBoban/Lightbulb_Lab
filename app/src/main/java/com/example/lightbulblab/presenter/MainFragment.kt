package com.example.lightbulblab.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lightbulblab.R
import com.example.lightbulblab.appComponent
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
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colors = arrayOf(
            "red", "green", "blue", "yellow",
            "teal","coral","peru","brown","gold"
            ,"maroon","mediumpurple","tomato"
            ,"white","pink","slateblue","indigo","cyan","seagreen","purple"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerColor.adapter = adapter

        binding.spinnerColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedColor = colors[position]
                viewModel.changeColor(selectedColor)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.seekbarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.let {
                    viewModel.setBrightness(it.progress)
                }
            }
        })

        binding.btnOn.setOnClickListener {
            viewModel.toggleLamp(true)
        }
        binding.btnOff.setOnClickListener {
            viewModel.toggleLamp(false)
        }
        viewModel.statusMessage.observe(viewLifecycleOwner){
            message ->
            Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
        }
    }
}

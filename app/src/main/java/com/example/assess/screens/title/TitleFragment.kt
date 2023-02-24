package com.example.assess.screens.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.assess.R
import com.example.assess.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    lateinit var binding:FragmentTitleBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container,false)
        binding.startBtn.setOnClickListener {view: View->

            if(binding.etName.text!!.isNotEmpty()){
                /// Move to next fragment, check if value is not empty on LOG in.

                view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment2)

            }else{
                Toast.makeText(context, "enter your name to start", Toast.LENGTH_SHORT).show()
            }


        }



        return binding.root
    }


}
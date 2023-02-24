package com.example.assess.screens.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.assess.R
import com.example.assess.databinding.FragmentScoreBinding
import com.example.assess.databinding.FragmentTitleBinding

class ScoreFragment : Fragment() {
    lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container,false)

        return binding.root
    }
}


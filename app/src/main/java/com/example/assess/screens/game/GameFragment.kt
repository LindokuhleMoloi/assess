package com.example.assess.screens.game

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.assess.Constants
import com.example.assess.Question
import com.example.assess.R
import com.example.assess.databinding.FragmentGameBinding
import com.example.assess.databinding.FragmentTitleBinding

class GameFragment : Fragment() , View.OnClickListener{
    lateinit var binding: FragmentGameBinding


    lateinit var mQuestionList: ArrayList<Question>

    private var mSelectedPosition: Int =0
    private var mCorrectAnswer : Int =0
    private var mCurrentPosition : Int= 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_game, container, false)

        mQuestionList = Constants.getQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        setQuestion()

        return binding.root
    }

    private fun setQuestion() {
        var question: Question = mQuestionList[mCurrentPosition ]

        binding.tvQuestion.text = question.question
        binding.imageView.setImageResource(question.image)

        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        binding.pb.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" +binding.pb.max

        defaultAppearance()

        if(mCurrentPosition == mQuestionList.size){
            binding.btnSubmit.text ="Quiz Finished"

        }else{
            binding.btnSubmit.text = "Submit"
        }

    }

    private fun defaultAppearance() {

        // ctrl text view that share sam behavior
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2 , binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options){

            option.setTextColor(Color.parseColor("#7A8089"))
            //DEFAULT APPEARANCE
            option.typeface = Typeface.DEFAULT
            option.background = context?.let { ContextCompat.getDrawable(it, R.drawable. default_option_border_bg)}


        }
    }

    override fun onClick(v: View?) {

        when(v?.id){

            R.id.tv_optionOne ->{

                SelectedOptionView(binding.tvOptionOne, 1)


            }
            R.id.tv_optionTwo ->{
                SelectedOptionView(binding.tvOptionTwo, 2)

            }
            R.id.tv_optionThree ->{
                SelectedOptionView(binding.tvOptionThree, 3)

            }
            R.id.tv_optionFour ->{
                SelectedOptionView(binding.tvOptionFour, 4)

            }
            R.id.btnSubmit ->{
                // if usr has not select
                if (mSelectedPosition== 0) {

                    mCurrentPosition++ // get new set of quiz

                    when{
                        mCurrentPosition<= mQuestionList.size ->{
                         setQuestion()
                    }else-> {
                        // go to result
                        Toast.makeText(context, "Quiz Finished" , Toast.LENGTH_SHORT).show()

                    }

                }
                }else{
                    // if user check if correct or incorrect
                    val question: Question? = mQuestionList[mCurrentPosition]

                    //if  sel pos 1..4 matches correct
                    //correct answer
                    if (question!!.correctAnswer!=mSelectedPosition){
                        answerView(mSelectedPosition, R.drawable.wrong_option_border)
                    } else{
                        mCorrectAnswer++

                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                        if(mCurrentPosition== mQuestionList.size){
                            binding.btnSubmit.text ="Finished"
                        }else{
                            binding.btnSubmit.text = "Go to next Question"
                        }
                    }

                    mSelectedPosition = 0
                }

            }
        }

    }

    private fun SelectedOptionView(tv: TextView,selectedPosition : Int) {
        //reset text views
        defaultAppearance()

        mSelectedPosition = selectedPosition

        tv.setTextColor(Color.parseColor("#363A43"))
        //default appearance
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = context?.let { ContextCompat.getDrawable(it,R.drawable.selected_option_border_bg) }



    }

    private fun answerView(mSelectedPosition: Int, drawableView: Int) {
         when (mSelectedPosition){
             1->{
                 binding.tvOptionOne.background =
                     context?.let { ContextCompat.getDrawable(it, drawableView) }

             }
         }
        when (mSelectedPosition){
            2->{
                binding.tvOptionTwo.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }


            }
        }
        when (mSelectedPosition){
            3->{
                binding.tvOptionThree.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }
        }
        when (mSelectedPosition){
            4->{
                binding.tvOptionFour.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }
        }


    }

}


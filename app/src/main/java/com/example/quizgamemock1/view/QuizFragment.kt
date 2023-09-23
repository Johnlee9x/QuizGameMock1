package com.example.quizgamemock1.view

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizgamemock1.R
import com.example.quizgamemock1.databinding.FragmentQuizBinding
import com.example.quizgamemock1.viewmodel.QuizViewModel
import com.example.quizgamemock1.viewmodel.ScoreViewModel

class QuizFragment : Fragment() {
    private lateinit var fragmentQuizBinding: FragmentQuizBinding
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var quiViewModel: QuizViewModel
    private lateinit var countDown: CountDownTimer
    private lateinit var resultFragment: ResultFragment
    private var crectAns = ""
    private var numCrt = 0
    private var numWrong = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentQuizBinding = FragmentQuizBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return fragmentQuizBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quiViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        resultFragment = ResultFragment()
        showQtion()
        chooseAnswer()
        fragmentQuizBinding.btnNext.setOnClickListener {
            showQtion()
            chooseAnswer()
        }
        fragmentQuizBinding.btnFinish.setOnClickListener {

        }

    }

    private fun chooseAnswer(){
        fragmentQuizBinding.txtA.setOnClickListener {
            stopCntDown()
           if(crectAns == "a"){
               numCrt++
           }
            else{
                numWrong++
               fragmentQuizBinding.txtA.setBackgroundColor(Color.RED)
           }
            showAnswer()
        }
        fragmentQuizBinding.txtB.setOnClickListener {
            stopCntDown()
            if(crectAns =="b"){
                numCrt++

            }else{
                numWrong++
                fragmentQuizBinding.txtB.setBackgroundColor(Color.RED)
            }
            showAnswer()

        }
        fragmentQuizBinding.txtC.setOnClickListener {
            stopCntDown()
            if(crectAns == "c"){
                numCrt++
            }
            else{
                numWrong++
                fragmentQuizBinding.txtC.setBackgroundColor(Color.RED)
            }
            showAnswer()
        }
        fragmentQuizBinding.txtD.setOnClickListener {
            stopCntDown()
            if(crectAns == "d"){
                numCrt++
            }
            else{
                numWrong ++
                fragmentQuizBinding.txtD.setBackgroundColor(Color.RED)
            }
            showAnswer()
        }
    }

    fun showAnswer(){
        when(crectAns){
            "a" -> {
                fragmentQuizBinding.txtA.setBackgroundColor(Color.GREEN)
                fragmentQuizBinding.txtNumcrt.text = "{$numCrt}"
                fragmentQuizBinding.txtNumwrong.text = "{$numWrong}"
            }
            "b" -> {
                fragmentQuizBinding.txtB.setBackgroundColor(Color.GREEN)
                fragmentQuizBinding.txtNumcrt.text = "{$numCrt}"
                fragmentQuizBinding.txtNumwrong.text = "{$numWrong}"
            }
            "c" -> {
                fragmentQuizBinding.txtC.setBackgroundColor(Color.GREEN)
                fragmentQuizBinding.txtNumcrt.text = "{$numCrt}"
                fragmentQuizBinding.txtNumwrong.text = "{$numWrong}"
            }
            "d" -> {
                fragmentQuizBinding.txtC.setBackgroundColor(Color.GREEN)
                fragmentQuizBinding.txtNumcrt.text = "{$numCrt}"
                fragmentQuizBinding.txtNumwrong.text = "{$numWrong}"
            }
        }
    }
    fun closeClickAble(){
        fragmentQuizBinding.txtA.isClickable = false
        fragmentQuizBinding.txtB.isClickable = false
        fragmentQuizBinding.txtC.isClickable = false
        fragmentQuizBinding.txtD.isClickable = false
    }
    fun refreshOptions(){
        fragmentQuizBinding.txtA.isClickable = true
        fragmentQuizBinding.txtB.isClickable = true
        fragmentQuizBinding.txtC.isClickable = true
        fragmentQuizBinding.txtD.isClickable = true

        fragmentQuizBinding.txtA.setBackgroundColor(Color.WHITE)
        fragmentQuizBinding.txtB.setBackgroundColor(Color.WHITE)
        fragmentQuizBinding.txtC.setBackgroundColor(Color.WHITE)
        fragmentQuizBinding.txtD.setBackgroundColor(Color.WHITE)
    }



    fun showQtion(){
        refreshOptions()
        quiViewModel.listQtionLiveData.observe(this@QuizFragment.viewLifecycleOwner, Observer { listQtion ->
            var qtionNumCrt = 1
            var totalNum = listQtion.size
            if(qtionNumCrt <= totalNum){
                val qtioncurrent = listQtion[qtionNumCrt]
                fragmentQuizBinding.apply {
                    txtQuestion.text = qtioncurrent.question.toString()
                    txtA.text = qtioncurrent.ansA.toString()
                    txtB.text = qtioncurrent.ansB.toString()
                    txtC.text = qtioncurrent.ansC.toString()
                    txtD.text = qtioncurrent.ansD.toString()
                    crectAns = qtioncurrent.crAnswer.toString()
                    Log.d("ansA",  txtA.text.toString())
                }
            }
            else{
                val dialogMsg = AlertDialog.Builder(this@QuizFragment.requireContext())
                dialogMsg.setTitle("Quiz Game")
                dialogMsg.setMessage("Finish the Quiz, see the result")
                dialogMsg.setCancelable(false)
                dialogMsg.setPositiveButton("Result"){_,_
                ->

                }
                dialogMsg.setNegativeButton("Play again"){_, _
                    ->
                }
                dialogMsg.create().show()
            }

            qtionNumCrt++
        })
        starCntDown()

    }

    fun starCntDown(){
        countDown = object : CountDownTimer(30000, 1000) {
            override fun onTick(tilFn: Long) {
                fragmentQuizBinding.txtCntdown.text = (tilFn / 1000).toString()
            }

            override fun onFinish() {
                closeClickAble()
                fragmentQuizBinding.txtQuestion.text = getString(R.string.time_over)
            }

        }.start()
    }

    fun stopCntDown(){
        countDown.cancel()
    }




}
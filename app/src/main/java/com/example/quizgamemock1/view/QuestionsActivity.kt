package com.example.quizgamemock1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.quizgamemock1.R
import com.example.quizgamemock1.databinding.ActivityMainBinding
import com.example.quizgamemock1.viewmodel.QuizViewModel

class QuestionsActivity : AppCompatActivity() {
    lateinit var txtQ : TextView
    lateinit var txtA : TextView
    lateinit var txtB : TextView
    lateinit var txtC : TextView
    lateinit var txtD : TextView
    var crtAns = ""
    private lateinit var questionViewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_quiz)

        questionViewBinding = ActivityMainBinding.inflate(layoutInflater)

        var quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        quizViewModel.listQtion.observe(this, Observer { value ->
            val listSize = value.size
            val numCrQtion = 1
            if(numCrQtion <= listSize){
                val qtion = value[numCrQtion]
                txtQ.setText(qtion.question.toString())
                txtA.setText(qtion.ansA.toString())
                txtB.setText(qtion.ansB.toString())
                txtC.setText(qtion.ansC.toString())
                txtD.setText(qtion.ansD.toString())
                crtAns = qtion.crAnswer.toString()

            }
        })




    }

}
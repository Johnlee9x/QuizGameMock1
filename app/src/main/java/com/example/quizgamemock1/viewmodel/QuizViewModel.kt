package com.example.quizgamemock1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizgamemock1.data.model.Questions
import com.example.quizgamemock1.data.repository.QuestionsRepo

class QuizViewModel(): ViewModel() {
    private val listQtLivedata = MutableLiveData<List<Questions>>()

    private val listQtionRepo = QuestionsRepo().getQuestions1()

    init {
        listQtLivedata.value = listQtionRepo
    }
    val listQtionLiveData : LiveData<List<Questions>>
        get() = listQtLivedata

    fun getQtions(): List<Questions>{
        val listQs = arrayListOf<Questions>()
        listQtLivedata.value?.map { q -> listQs.add(q)}
        return listQs
    }

}
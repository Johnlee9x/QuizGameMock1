package com.example.quizgamemock1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizgamemock1.data.model.Scores
import com.example.quizgamemock1.data.repository.ScoreRepo

class ScoreViewModel : ViewModel() {
    private val scoreMutableLiveData = MutableLiveData<Scores>()
    private val score = ScoreRepo().getResult()

    val scoreLive_data: LiveData<Scores>
        get() = scoreMutableLiveData

    fun getResult(): Scores{
        scoreMutableLiveData.value = score
        return score
    }

    fun saveResult( numberWrong: String,numberCrt: String){
        ScoreRepo().saveRecord(numberCrt, numberWrong)
        scoreMutableLiveData.value = Scores(numberCrt, numberWrong)
    }


}
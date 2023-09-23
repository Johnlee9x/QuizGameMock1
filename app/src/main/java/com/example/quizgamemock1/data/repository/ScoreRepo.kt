package com.example.quizgamemock1.data.repository

import android.content.Intent
import android.widget.Toast
import com.example.quizgamemock1.data.model.Scores
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ScoreRepo {
    private lateinit var userAuthenRepo: UserAuthenRepo
    private val authen = FirebaseAuth.getInstance()
    private val user = authen.currentUser
    private lateinit var database: FirebaseDatabase
    private val scoreDb = database.reference

    fun saveRecord(numCrt: String, numWrong: String){
        user.let {
            scoreDb.child("${user?.uid}").child("wrongnum").setValue(numWrong)
            scoreDb.child("${user?.uid}").child("correctnum").setValue(numCrt)
        }
    }
    fun getResult(): Scores {
        val numberWrong = scoreDb.child("${user?.uid}").child("wrongnum").get().toString()
        val numberCrt = scoreDb.child("${user?.uid}").child("correctnum").get().toString()
        return Scores(numberWrong,numberCrt)
    }


}
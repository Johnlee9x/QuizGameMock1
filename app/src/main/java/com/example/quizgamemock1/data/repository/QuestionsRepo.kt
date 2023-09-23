package com.example.quizgamemock1.data.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.quizgamemock1.data.model.Questions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class QuestionsRepo {
    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var refDaba: DatabaseReference = database.reference.child("Questions")
    fun getQuestions(liveData :MutableLiveData<List<Questions>>){
        var listQtionMuLiveData = MutableLiveData<List<Questions>>()
        refDaba.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val listQuestion: List<Questions> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Questions::class.java)!!
                    }
                    liveData.postValue(listQuestion)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun getQuestions1(): List<Questions>{
        var list = arrayListOf<Questions>()
        refDaba.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    list = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Questions::class.java)!!
                    } as ArrayList<Questions>
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return list
    }



}
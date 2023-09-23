package com.example.quizgamemock1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizgamemock1.data.repository.UserAuthenRepo

class UserAuthenViewModel: ViewModel() {
    /*private val user = MutableLiveData<User>()
    var userRepo = UserRepo()
    init {

    }

    val userLiveData: LiveData<User>
        get() = user*/
    private val markMutableLiveData = MutableLiveData<Boolean>()

    val markLiveData: LiveData<Boolean>
        get() = markMutableLiveData



   /* private val firebaseUserliveData: LiveData<FirebaseUser>
        get() = firebaseUserMutableLiveData*/


    var userAuthen = UserAuthenRepo()

    fun signUp(email: String, password: String){
        userAuthen.signUp(email, password)
        markMutableLiveData.value = true
    }

    fun signIn(email: String, password: String ){
       userAuthen.signIn(email, password)
        markMutableLiveData.value = true
    }






    /*private fun signInWithAccount(email: String, password: String){
        if(email.isEmpty() || password.isEmpty()){

        }
        else{

            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if(task.isSuccessful){

                }
                else{


                }
            }
        }
    }
    private fun saveUser() {
    }*/



}






package com.example.quizgamemock1.data.repository

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserAuthenRepo {
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val Req_Code: Int = 123

    private  var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
/*    private val application: Application? = null*/
    /*private val firebaseUserMutableLiveData: MutableLiveData<FirebaseUser>? = null
    val firebaseUserLiveData: LiveData<FirebaseUser>
        get() =  firebaseUserLiveData
    */
    val getCrrentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    fun signUp(email: String, password: String){

    /*    var mark = false*/
       firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
           if(task.isSuccessful){
               /*firebaseUserMutableLiveData?.postValue(firebaseAuth.currentUser)
               Toast.makeText(application, "Successful", Toast.LENGTH_SHORT).show()*/
             /*  mark = true*/

           }
           else{
               /*Toast.makeText(application, "failed", Toast.LENGTH_SHORT).show()*/

           }

       }
      /*  return mark*/

    }

    fun signIn(email: String, passwrod: String){

       /* var mark = false*/
        firebaseAuth.signInWithEmailAndPassword(email, passwrod).addOnCompleteListener {task ->
            if(task.isSuccessful){
               /* firebaseUserMutableLiveData?.postValue(firebaseAuth.currentUser)*/

            }
            else{

            }
        }
    }
    fun signOut(){
        firebaseAuth.signOut()
    }



}
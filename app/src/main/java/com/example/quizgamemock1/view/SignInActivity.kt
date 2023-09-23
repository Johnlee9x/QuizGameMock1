package com.example.quizgamemock1.view

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizgamemock1.R
import com.example.quizgamemock1.databinding.AcivitySigninBinding
import com.example.quizgamemock1.viewmodel.UserAuthenViewModel

class SignInActivity : AppCompatActivity() {
    lateinit var binding:AcivitySigninBinding
    lateinit var userModel: UserAuthenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userModel = ViewModelProvider(this).get(UserAuthenViewModel::class.java)
        goSignIn()

        binding.txtSignup.setOnClickListener {
            /*binding.signinLayout.visibility = View.INVISIBLE
            binding.imageViewApp.visibility = View.INVISIBLE*/
            val signUpFragment = SignUpFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_signIn, signUpFragment)
                addToBackStack(null)
                commit()

            }

        }
    }

    fun goSignIn(){
        binding.btSignin.setOnClickListener {
            var email = binding.edtEmailInputSignin.text.toString()
            var pass = binding.edtSigninPasswordInput.text.toString()
            if(email.isNotBlank() && pass.isNotBlank()){
                userModel.signIn(email,pass)

            }
            else{
                Toast.makeText(this, "input missmatch", Toast.LENGTH_SHORT).show()
            }
            userModel.markLiveData.observe(this@SignInActivity, Observer { mark ->
                if(mark){
                    Toast.makeText(this, "Fragment", Toast.LENGTH_SHORT).show()
                    val homePageFragment = HomePageFragment()
                    val homepageFragmentManage: FragmentManager = supportFragmentManager
                    val homePageFragmentTransaction: FragmentTransaction = homepageFragmentManage.beginTransaction()
                    homePageFragmentTransaction.replace(R.id.fl_signIn, homePageFragment)
                    homePageFragmentTransaction.addToBackStack(null)
                    homePageFragmentTransaction.commit()

                }
            })



        }
    }
}
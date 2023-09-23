package com.example.quizgamemock1.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizgamemock1.R
import com.example.quizgamemock1.viewmodel.UserAuthenViewModel
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {
    private lateinit var txtInputEmail: EditText
    private lateinit var txtInputPsw: EditText
    private lateinit var btnSignUp: Button
    private lateinit var userAuthenViewModel: UserAuthenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_sign_up, container, false)
        return view
        // Inflatethe layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSignUp = view.findViewById(R.id.buttonsignup)
        txtInputEmail = view.findViewById(R.id.txt_inputemailsignup)

        txtInputPsw = view.findViewById(R.id.txt_inputpasswordsignup)


        btnSignUp.setOnClickListener {
            val email: String = txtInputEmail.text.toString()
            val pass: String = txtInputPsw.text.toString()
            Log.d("email", email)
            Log.d("pass", pass)

            if(email.isNotBlank() && pass.isNotBlank()){
                userAuthenViewModel.signUp(email, pass)

            }
            else{

            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userAuthenViewModel = ViewModelProvider(this).get(UserAuthenViewModel::class.java)
    }





}
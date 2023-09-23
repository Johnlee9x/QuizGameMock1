package com.example.quizgamemock1.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizgamemock1.R
import com.example.quizgamemock1.databinding.FragmentResultBinding
import com.example.quizgamemock1.viewmodel.ScoreViewModel
import com.google.android.material.color.utilities.Score

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    private lateinit var resultFragmentBinding: FragmentResultBinding
    private lateinit var soreViewModel: ScoreViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultFragmentBinding = FragmentResultBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return resultFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        soreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)


    }

    fun getRecord(){
        resultFragmentBinding.numWrongans.text = soreViewModel.getResult().numberWrong
        resultFragmentBinding.numCrt.text = soreViewModel.getResult().numberCorrect

        soreViewModel.scoreLive_data.observe(this, Observer {score ->
            if(score != null){
                Log.d("Tagsth", "Success")
            }
            else{
                //TODO sth up to you
            }
        })
    }


}
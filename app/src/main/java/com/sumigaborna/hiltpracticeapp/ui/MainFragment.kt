package com.sumigaborna.hiltpracticeapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sumigaborna.hiltpracticeapp.R

class MainFragment constructor(private val someString:String): Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Fragment says: $someString")
    }
}
package com.sumigaborna.hiltpracticeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(someClass.doAThing())
    }
}

@AndroidEntryPoint
class MyFragment : Fragment(){

    @Inject
    lateinit var someClass: SomeClass

}

//@FragmentScoped //this won't run because fragment scope is smaller than @ActivityScoped
@ActivityScoped
class SomeClass @Inject constructor() {
    fun doAThing(): String = "Look I did a thing"
}
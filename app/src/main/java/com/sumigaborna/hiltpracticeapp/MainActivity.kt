package com.sumigaborna.hiltpracticeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())
    }
}

class SomeClass @Inject constructor(private val someOtherClass: SomeOtherClass){
    fun doAThing():String = "Look I did a thing"
    fun doSomeOtherThing():String = someOtherClass.doSomeOtherThing()
}

class SomeOtherClass @Inject constructor(){
    fun doSomeOtherThing() : String = "Look this is some other thing"
}
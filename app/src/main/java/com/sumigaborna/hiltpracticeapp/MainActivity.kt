package com.sumigaborna.hiltpracticeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

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

class SomeClass
@Inject
constructor(
        private val someInterfaceImpl: SomeInterface,
        private val gson: Gson
) {
    fun doAThing(): String {
        return "Look I got: ${someInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl @Inject constructor() : SomeInterface {
    override fun getAThing(): String {
        return "A Thing"
    }
}

interface SomeInterface {
    fun getAThing(): String
}

@InstallIn(ActivityComponent::class)
@Module
class MyModule {
    @ActivityScoped
    @Provides
    fun bindSomeDependency(someInterfaceImpl: SomeInterfaceImpl): SomeInterface = someInterfaceImpl

    @ActivityScoped
    @Provides
    fun bindGson(): Gson {
        return Gson()
    }
}
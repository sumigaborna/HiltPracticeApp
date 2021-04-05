package com.sumigaborna.hiltpracticeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sumigaborna.hiltpracticeapp.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Qualifier

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainFragment::class.java, null)
            .commitAllowingStateLoss()

    }
}
/*

class SomeClass
@Inject
constructor(
    @Impl1 private val someInterfaceImpl1: SomeInterface,
    @Impl2 private val someInterfaceImpl2: SomeInterface,
) {
    fun doAThing1(): String {
        return "Look I got: ${someInterfaceImpl1.getAThing()}"
    }

    fun doAThing2(): String {
        return "Look I got: ${someInterfaceImpl2.getAThing()}"
    }
}

class SomeInterfaceImpl1 @Inject constructor() : SomeInterface {
    override fun getAThing(): String {
        return "A Thing1"
    }
}

class SomeInterfaceImpl2 @Inject constructor() : SomeInterface {
    override fun getAThing(): String {
        return "A Thing2"
    }
}

interface SomeInterface {
    fun getAThing(): String
}

@InstallIn(ActivityComponent::class)
@Module
class MyModule {
    @Impl1
    @ActivityScoped
    @Provides
    fun bindSomeDependency1(someInterfaceImpl1: SomeInterfaceImpl1): SomeInterface = someInterfaceImpl1

    @Impl2
    @ActivityScoped
    @Provides
    fun bindSomeDependency2(someInterfaceImpl2: SomeInterfaceImpl2): SomeInterface = someInterfaceImpl2
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2*/

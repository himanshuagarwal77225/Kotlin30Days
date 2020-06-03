package dev.himanshu.kotlin30days

import android.app.Application
import com.facebook.stetho.Stetho
import dev.himanshu.kotlin30days.di.listOfModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Kotlin30DaysApplication  : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@Kotlin30DaysApplication)
            modules(listOfModules)
        }
    }
}
package com.example.meeting

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.meeting.dependencyinjection.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MeetingApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MeetingApplication)
            modules(appModules)
        }
    }
}
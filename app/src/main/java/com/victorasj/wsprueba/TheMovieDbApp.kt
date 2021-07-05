package com.victorasj.wsprueba

import android.app.Application
import com.facebook.stetho.Stetho

class TheMovieDbApp : Application() {

    init {
        initServiceLocator()
        //Stetho.initializeWithDefaults(baseContext);
    }
}
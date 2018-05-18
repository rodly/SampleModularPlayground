package com.rodly.samplemodularplayground

import android.app.Application
import com.rodly.di.BaseComponent
import com.rodly.di.ComponentProvider
import com.rodly.di.DaggerBaseComponent

class PlaygroundApplication : Application(), ComponentProvider {

  override lateinit var baseComponent: BaseComponent

  override fun onCreate() {
    super.onCreate()
    baseComponent = DaggerBaseComponent.create()
  }

}

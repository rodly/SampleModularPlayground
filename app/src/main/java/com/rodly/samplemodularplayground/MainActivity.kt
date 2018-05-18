package com.rodly.samplemodularplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodly.samplemodularplayground.presentation.index.PersonIndexScreen

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    supportFragmentManager
        .beginTransaction()
        .add(R.id.container, PersonIndexScreen())
        .commit()
  }

}

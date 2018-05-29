package com.rodly.samplemodularplayground

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.rodly.domain.Person
import com.rodly.persondetail.PersonDetailScreen
import com.rodly.samplemodularplayground.nav.NavigableFragment
import com.rodly.samplemodularplayground.nav.Navigator
import com.rodly.samplemodularplayground.presentation.index.PersonIndexScreen

class MainActivity : AppCompatActivity(), Navigator {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      supportFragmentManager
          .beginTransaction()
          .add(R.id.container, PersonIndexScreen())
          .commitNow()
    }
  }

  private fun navigate(destination: NavigableFragment) {
    supportFragmentManager
        .beginTransaction()
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .replace(R.id.container, destination)
        .addToBackStack(null)
        .commit()
  }

  override fun personDetail(person: Person) = navigate(PersonDetailScreen.newInstance(person))

}

package com.rodly.samplemodularplayground.presentation.index

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.rodly.di.ComponentProvider
import com.rodly.domain.PersonRepository
import com.rodly.samplemodularplayground.DaggerViewComponent
import com.rodly.samplemodularplayground.nav.NavigableFragment
import javax.inject.Inject

class PersonIndexScreen : NavigableFragment() {

  @Inject
  lateinit var repository: PersonRepository

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    DaggerViewComponent.builder()
        .baseComponent((context!!.applicationContext as ComponentProvider).baseComponent)
        .build()
        .inject(this)

    return Button(context).apply {
      val person = repository.getExamplePerson()
      text = person.name
      setOnClickListener {
        navigator!!.personDetail(person)
      }
    }
  }

}

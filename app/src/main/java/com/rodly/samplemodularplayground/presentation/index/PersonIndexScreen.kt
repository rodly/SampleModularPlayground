package com.rodly.samplemodularplayground.presentation.index

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.rodly.di.ComponentProvider
import com.rodly.domain.PersonRepository
import com.rodly.persondetail.PersonDetailScreen
import com.rodly.samplemodularplayground.DaggerViewComponent
import com.rodly.samplemodularplayground.PlaygroundApplication
import com.rodly.samplemodularplayground.R
import javax.inject.Inject

class PersonIndexScreen : Fragment() {

  @Inject
  lateinit var repository: PersonRepository

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    DaggerViewComponent.builder()
        .baseComponent((context!!.applicationContext as ComponentProvider).baseComponent)
        .build()
        .inject(this)

    return Button(context).apply {
      text = repository.getPerson().name
      setOnClickListener {
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.container, PersonDetailScreen())
            .addToBackStack(null)
            .commit()
      }
    }
  }

  override fun onResume() {
    super.onResume()
    Toast.makeText(activity!!, repository.getPersons().toString(), Toast.LENGTH_LONG).show()
  }

}

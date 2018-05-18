package com.rodly.persondetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rodly.di.ComponentProvider
import com.rodly.domain.PersonRepository
import javax.inject.Inject

class PersonDetailScreen : Fragment() {

  @Inject
  lateinit var repository: PersonRepository

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    DaggerPersonDetailViewComponent.builder()
        .baseComponent((context!!.applicationContext as ComponentProvider).baseComponent)
        .build()
        .inject(this)
    return super.onCreateView(inflater, container, savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    Toast.makeText(activity!!, repository.getPerson().toString(), Toast.LENGTH_LONG).show()
  }

}

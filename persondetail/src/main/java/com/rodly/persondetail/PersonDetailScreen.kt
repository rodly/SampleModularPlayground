package com.rodly.persondetail

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import com.rodly.di.ComponentProvider
import com.rodly.domain.Person
import com.rodly.domain.PersonRepository
import com.rodly.samplemodularplayground.nav.NavigableFragment
import javax.inject.Inject

class PersonDetailScreen : NavigableFragment() {

  @Inject
  lateinit var repository: PersonRepository

  private lateinit var person: Person

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DaggerPersonDetailViewComponent.builder()
        .baseComponent((context!!.applicationContext as ComponentProvider).baseComponent)
        .build()
        .inject(this)

    person = repository.getPerson(arguments!!.getString(ARG_PERSON_NAME))!!
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    val view = inflater.inflate(R.layout.person_detail, container, false)

    val toolbarView: Toolbar = view.findViewById(R.id.person_detail_toolbar)
    toolbarView.setNavigationOnClickListener {
      navigator!!.onBackPressed()
    }

    val nameView: TextView = view.findViewById(R.id.person_detail_name)
    nameView.text = person.name

    val friendsContainerView: ViewGroup = view.findViewById(R.id.person_detail_friends_container)
    repository.getFriends(person).forEach { friend ->
      val friendView: TextView = inflater.inflate(R.layout.friend_item, friendsContainerView, false) as TextView
      friendView.apply {
        text = friend.name
        setOnClickListener {
          navigator!!.personDetail(friend)
        }
      }
      friendsContainerView.addView(friendView)
    }

    return view
  }

  companion object {

    private const val ARG_PERSON_NAME = "person_name"

    fun newInstance(person: Person): PersonDetailScreen {
      return PersonDetailScreen().apply {
        arguments = bundleOf(
            ARG_PERSON_NAME to person.name
        )
      }
    }
  }

}

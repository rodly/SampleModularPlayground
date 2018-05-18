package com.rodly.data

import com.rodly.domain.Person
import com.rodly.domain.PersonRepository

class PersonRepositoryImpl : PersonRepository {

  override fun getPerson(): Person {
    return Person("Rodney")
  }

  override fun getPersons(): List<Person> {
    return listOf(Person("Bob"), Person("Sally"))
  }
}

package com.rodly.data

import com.rodly.domain.Person
import com.rodly.domain.PersonRepository

class PersonRepositoryImpl : PersonRepository {

  override fun getExamplePerson(): Person {
    return getPersons().first()
  }

  override fun getPerson(name: String): Person? {
    return getPersons().find { it.name == name }
  }

  override fun getPersons(): List<Person> {
    return listOf(Person("Rodney"), Person("Bob"), Person("Sally"))
  }

  override fun getFriends(person: Person): List<Person> {
    return getPersons().minus(person)
  }

}

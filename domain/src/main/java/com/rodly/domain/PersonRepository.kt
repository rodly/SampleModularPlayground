package com.rodly.domain

interface PersonRepository {
  fun getExamplePerson(): Person
  fun getPerson(name: String): Person?
  fun getPersons(): List<Person>
  fun getFriends(person: Person): List<Person>
}

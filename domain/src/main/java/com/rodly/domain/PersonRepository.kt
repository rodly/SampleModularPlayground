package com.rodly.domain

interface PersonRepository {
  fun getPerson(): Person
  fun getPersons(): List<Person>
}

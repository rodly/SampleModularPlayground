package com.rodly.di

import com.rodly.domain.PersonRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PersonDataModule::class])
interface BaseComponent {
  fun personRepository(): PersonRepository
}

package com.rodly.di

import com.rodly.domain.PersonRepository
import com.rodly.data.PersonRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersonDataModule {

  @Provides
  @Singleton
  fun personRepository(): PersonRepository = PersonRepositoryImpl()

}

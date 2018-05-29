package com.rodly.samplemodularplayground.nav

import com.rodly.domain.Person

interface Navigator {

  fun onBackPressed()

  fun personDetail(person: Person)

}

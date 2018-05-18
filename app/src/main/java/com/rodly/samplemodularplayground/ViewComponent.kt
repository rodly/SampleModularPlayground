package com.rodly.samplemodularplayground

import com.rodly.di.BaseComponent
import com.rodly.di.FeatureScope
import com.rodly.samplemodularplayground.presentation.index.PersonIndexScreen
import dagger.Component

@FeatureScope
@Component(dependencies = [BaseComponent::class])
interface ViewComponent {
  fun inject(screen: PersonIndexScreen)
}

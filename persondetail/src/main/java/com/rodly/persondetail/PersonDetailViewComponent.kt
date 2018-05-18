package com.rodly.persondetail

import com.rodly.di.BaseComponent
import com.rodly.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(dependencies = [BaseComponent::class])
interface PersonDetailViewComponent {
  fun inject(screen: PersonDetailScreen)
}

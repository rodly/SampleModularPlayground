package com.rodly.samplemodularplayground.nav

import android.support.v4.app.Fragment

abstract class NavigableFragment : Fragment() {

  protected val navigator: Navigator? get() = activity as? Navigator

}

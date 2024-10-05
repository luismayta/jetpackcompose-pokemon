// Top-level build file where you can add configuration options common to all sub-projects/modules.k
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.serialization) apply false
  alias(libs.plugins.devtools.ksp) apply false
  alias(libs.plugins.dagger.hilt) apply false
//  alias(libs.plugins.navigation.safe.args.plugin) apply false
}
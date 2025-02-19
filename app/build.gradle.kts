plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.jetbrains.kotlin.serialization)
  alias(libs.plugins.kotlin.parcelize)
  alias(libs.plugins.dagger.hilt)
  alias(libs.plugins.devtools.ksp)
}

android {
  namespace = "com.luismayta.composehelloworld"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.luismayta.jetpackcomposepokemon"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.15"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  implementation(libs.androidx.lifecycle.ktx)
// coil
  implementation(libs.coil.compose)

  implementation(libs.androidx.lifecycle.viewmodel.compose)

//  ktor
  implementation(libs.ktor.client.core)
  implementation(libs.ktor.client.cio)
  implementation(libs.ktor.client.okhttp)
  implementation(libs.ktor.client.logging)
  implementation(libs.ktor.client.content.negotiation)
  implementation(libs.ktor.serialization.kotlinx.json)
  implementation(libs.ktor.client.encoding)

  //dagger
  implementation(libs.hilt.android)
  implementation(libs.androidx.hilt.navigation.compose)
  ksp(libs.hilt.compiler)

//  navigation

  // Jetpack Compose integration
  implementation(libs.androidx.navigation.compose)
  implementation(libs.kotlinx.serialization.json)

  // Views/Fragments integration
  implementation(libs.navigation.fragment)
  implementation(libs.navigation.ui)

  // Feature module support for Fragments
  implementation(libs.navigation.dynamic)

  // Testing Navigation
  androidTestImplementation(libs.navigation.testing)

//  test
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)

  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)
}
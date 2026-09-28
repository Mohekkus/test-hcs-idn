plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.ksp)
    alias(libs.plugins.android.hilt)
    alias(libs.plugins.androidx.navigation.safeargs)
}

android {
    namespace = "cc.shinemoon.presentation"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Domain layer
    implementation(project(":domain"))

    // Core AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Fragment + ViewModel + LiveData
    implementation(libs.androidx.fragments.ktx)
    implementation(libs.androidx.viewmodel.ktx)
    implementation(libs.androidx.livedata.ktx)

    // RecyclerView + Glide (for UserListAdapter, etc.)
    implementation(libs.androidx.recyclerview)
    implementation(libs.glide.image)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Coroutines (ViewModels, lifecycleScope, flow, etc.)
    implementation(libs.kotlin.coroutine.core)
    implementation(libs.kotlin.coroutine.android)

    // Navigation Fragments
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    // Unit tests
    testImplementation(libs.junit)
    // testImplementation(libs.kotlin.coroutine.test)

    // Android tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
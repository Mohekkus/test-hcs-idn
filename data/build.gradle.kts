plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.ksp)
    alias(libs.plugins.android.hilt)
}

android {
    namespace = "cc.shinemoon.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // Domain layer
    implementation(project(":domain"))

    // Core AndroidX (if needed directly in data)
    implementation(libs.androidx.core.ktx)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    // Room
    implementation(libs.androidx.room)
    implementation(libs.androidx.sqlite)
    ksp(libs.androidx.room.compiler)

    // Retrofit + Moshi + OkHttp
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)

    // Chucker (debug only)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    // Coroutines (used in repos, DAOs, mappers with flow, etc.)
    implementation(libs.kotlin.coroutine.core)
    implementation(libs.kotlin.coroutine.android)

    // Unit tests
    testImplementation(libs.junit)
    testImplementation(libs.okhttp.mockwebserver)
    // testImplementation(libs.kotlin.coroutine.test)

    // Android tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
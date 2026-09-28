# GitHub User Search

An Android app for searching GitHub users, viewing search results, and opening a user's profile. Search results and profile data are cached locally with Room.

## Requirements

- Android Studio with support for Android Gradle Plugin 9.1.1
- JDK 17
- Android SDK 36
- Android device or emulator running API 24 or later

The Gradle wrapper downloads Gradle 9.3.1 when needed.

## Build and Run

Open the project in Android Studio and run the `app` configuration on a device or emulator.

The app requires internet access for GitHub API requests. Debug builds include Chucker for inspecting network traffic.

## Architecture

The project uses a multi-module MVVM structure:

- `app`: Android application, main activity, and application-level Hilt setup.
- `presentation`: search and user detail screens, ViewModels, UI state, navigation, and RecyclerView adapter.
- `domain`: user models, repository contract, and use cases.
- `data`: GitHub API integration, Room database and DAOs, repository implementation, and data mappers.

Hilt provides dependencies. Retrofit and OkHttp access the GitHub API; Moshi parses JSON; Room stores user data; Kotlin coroutines and `StateFlow` handle asynchronous work and UI state. Dependency versions are maintained in `gradle/libs.versions.toml`.

## Tests

The project includes local unit test and Android instrumented test source sets.
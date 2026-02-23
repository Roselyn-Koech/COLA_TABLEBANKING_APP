pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        kotlin("android") version "1.9.24" apply false
        id("com.android.application") version "8.7.3" apply false
        id("com.android.library") version "8.7.3" apply false
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")   // ✅ ADD THIS LINE
    }
}

rootProject.name = "COLATABLEBANKINGAPP"
include(":app")
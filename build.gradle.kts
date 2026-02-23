plugins {
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
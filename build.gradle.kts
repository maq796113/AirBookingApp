buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
    dependencies {

        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.google.relay") version "0.3.09" apply false
}

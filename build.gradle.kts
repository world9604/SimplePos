// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
}*/

buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        jcenter()
    }
    dependencies {
        classpath(libs.kotlin)
        classpath(libs.hilt.gradle)
        classpath(libs.androidx.navigation.args.gradle)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url = "https://www.jitpack.io")
    }
}
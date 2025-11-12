import org.jetbrains.kotlin.fir.declarations.builder.buildScript

plugins {
    id("module.android")
}

android {
    namespace = "com.example.simplepos.ui"
}

dependencies {
    implementation(projects.presentation)
}
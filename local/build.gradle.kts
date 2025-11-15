plugins {
    id("module.android")
}
android {
    namespace = "com.example.simplepos.local"
}

dependencies {
    implementation(projects.data)

    implementation(libs.gson)
    implementation(libs.androidx.room)
    kapt(libs.androidx.room.compiler)
}
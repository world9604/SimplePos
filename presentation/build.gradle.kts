plugins {
    id("module.android")
}
android {
    namespace = "com.example.simplepos.presentaion"
}

dependencies {
    implementation(projects.domain)
    implementation(libs.androidx.viewmodel)
}
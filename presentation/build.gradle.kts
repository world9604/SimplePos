plugins {
    id("module.android")
}
android {
    namespace = "com.example.simplepos.presentaion"
}

dependencies {
    implementation(projects.domain)
    implementation(projects.dataResource)

    implementation(libs.androidx.viewmodel)
}
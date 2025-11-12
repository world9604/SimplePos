plugins {
    id("module.android")
}
android {
    namespace = "com.example.simplepos.remote"
}

dependencies {
    implementation(projects.data)
}
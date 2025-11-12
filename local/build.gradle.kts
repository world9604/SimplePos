plugins {
    id("module.android")
}
android {
    namespace = "com.example.simplepos.local"
}
dependencies {
    implementation(projects.data)
}
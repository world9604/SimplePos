rootProject.name = "SimplePos"
include(":app")
include(":remote")
include(":local")
include(":presentation")
include(":ui")
include(":domain")
include(":data")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        jcenter()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":data-resource")

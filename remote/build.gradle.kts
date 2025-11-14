import java.util.Properties

plugins {
    id("module.android")
}

// local.properties 파일을 읽음
val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}


android {
    namespace = "com.example.simplepos.remote"

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"${localProperties["api_key"]}\"")

    }
}

dependencies {
    implementation(projects.data)

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
}
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.appblogfinal"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appblogfinal"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
     buildFeatures{
        viewBinding = true
     }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(platform(libs.firebase.bom))

    implementation(libs.firebase.auth)
    implementation(libs.google.firebase.firestore)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx.v282)
    implementation(libs.androidx.navigation.ui.ktx.v282)
    // Utils
    implementation(libs.circleimageview)
    implementation(libs.glide)
    implementation(libs.androidx.legacy.support.v4)
    annotationProcessor(libs.compiler)
    // Viewmodel and livedata KTX
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v287)
    implementation(libs.androidx.lifecycle.livedata.ktx.v287)

    // Play services coroutines
    implementation(libs.kotlinx.coroutines.play.services)
    //
    implementation(libs.jetbrains.kotlinx.coroutines.core)
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")



    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx.v287)



    // Navigation
    //implementation ("androidx.navigation:navigation-fragment-ktx:2.8.2")
    //implementation ("androidx.navigation:navigation-ui-ktx:2.8.2")
    // Utils
    //implementation ("de.hdodenhof:circleimageview:3.1.0")
    //implementation ("com.github.bumptech.glide:glide:4.16.0")
    //implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    //annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
    // Viewmodel and livedata KTX"
    //implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
    //implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    // Play services coroutines
    //implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
    //
    //implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    // Lifecycle
    //implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")



}
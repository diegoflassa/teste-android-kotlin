import io.github.diegoflassa.teste_android_kotlin.buildsrc.Config
import io.github.diegoflassa.teste_android_kotlin.buildsrc.Versions

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Config.compileSdkVersion
    //compileSdkPreview = Config.compileSdkPreviewVersion
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        minSdk = Config.minimumSdkVersion
        targetSdk = Config.targetSdkVersion
        //targetSdkPreview = Config.targetSdkPreviewVersion
        //versionCode = Config.versionCode
        //versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation("androidx.core:core-ktx:${Versions.core_ktx}")
    implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
    implementation("com.google.android.material:material:${Versions.material}")
    androidTestImplementation("junit:junit:${Versions.junit}")
    androidTestImplementation("androidx.test.ext:junit-ktx:${Versions.junit_ktx}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.espresso}")

    //Retrofix 2
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit_adapter}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")

    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:${Versions.moshi}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}")

    //GSON
    implementation("com.google.code.gson:gson:${Versions.gson}")

    // RX Java 3
    implementation("io.reactivex.rxjava3:rxjava:${Versions.rxjava}")
    implementation("io.reactivex.rxjava3:rxandroid:${Versions.rxandroid}")
}
plugins {
    id(CoreDependency.PLUGIN_APPLICATION)
    id(CoreDependency.PLUGIN_KOTLIN)
    id(CoreDependency.PLUGIN_HILT)
    id(CoreDependency.PLUGIN_KAPT)
    id(NetworkDependency.PLUGIN_SERIALIZATION) version "1.5.10"
}

android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGET_SDK_VERSION)
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

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
        freeCompilerArgs =
            listOf(*kotlinOptions.freeCompilerArgs.toTypedArray(), "-Xjvm-default=all")
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(CoreDependency.CORE_KTX)
    implementation(CoreDependency.RX_JAVA2)
    implementation(CoreDependency.RX_JAVA2_ANDROID)
    implementation(CoreDependency.HILT)
    kapt(CoreDependency.KAPT_HILT)

    implementation(PresentationsDependency.APP_COMPAT)
    implementation(PresentationsDependency.MATERIAL)
    implementation(PresentationsDependency.CONSTRAINT)
    implementation(PresentationsDependency.LIFECYCLE_VIEWMODEL)
    implementation(PresentationsDependency.NAVIGATION_FRAGMENT)
    implementation(PresentationsDependency.NAVIGATION_UI)
    implementation(PresentationsDependency.SHIMMER)
    implementation(PresentationsDependency.GROUPIE)
    implementation(PresentationsDependency.GROUPIE_BINDING)
    implementation(PresentationsDependency.GLIDE)
    kapt(PresentationsDependency.KAPT_GLIDE)

    implementation(NetworkDependency.RETROFIT)
    implementation(NetworkDependency.RETROFIT_SERIALIZATION)
    implementation(NetworkDependency.RETROFIT_RX_JAVA_2)
    implementation(NetworkDependency.SERIALIZATION)
    implementation(NetworkDependency.LOGGING_INTERCEPTOR)

    implementation(StorageDependency.ROOM)
    implementation(StorageDependency.ROOM_RX_JAVA2)
    kapt(StorageDependency.KAPT_ROOM)
}
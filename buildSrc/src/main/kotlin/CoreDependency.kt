private object CoreVersions {
    const val CORE_KTX = "1.7.0"

    const val RX_JAVA2 = "2.2.2"
    const val RX_ANDROID = "2.0.1"
    const val HILT = "2.38.1"
}

object CoreDependency {

    const val PLUGIN_APPLICATION = "com.android.application"
    const val PLUGIN_KOTLIN = "org.jetbrains.kotlin.android"
    const val PLUGIN_HILT = "dagger.hilt.android.plugin"
    const val PLUGIN_KAPT = "kotlin-kapt"
    const val PLUGIN_PARCELIZE = "kotlin-parcelize"

    const val CLASSPATH_HILT = "com.google.dagger:hilt-android-gradle-plugin:${CoreVersions.HILT}"

    const val CORE_KTX = "androidx.core:core-ktx:${CoreVersions.CORE_KTX}"

    const val RX_JAVA2 = "io.reactivex.rxjava2:rxjava:${CoreVersions.RX_JAVA2}"
    const val RX_JAVA2_ANDROID = "io.reactivex.rxjava2:rxandroid:${CoreVersions.RX_ANDROID}"

    const val HILT = "com.google.dagger:hilt-android:${CoreVersions.HILT}"
    const val KAPT_HILT = "com.google.dagger:hilt-android-compiler:${CoreVersions.HILT}"
}

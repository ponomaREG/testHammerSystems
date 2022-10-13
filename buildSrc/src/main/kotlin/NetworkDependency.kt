private object NetworkVersions {

    const val RETROFIT = "2.9.0"
    const val LOGGING_INTERCEPTOR = "4.9.0"
    const val RETROFIT_SERIALIZATION = "0.8.0"
    const val SERIALIZATION = "1.2.2"
}

object NetworkDependency {

    const val PLUGIN_SERIALIZATION = "org.jetbrains.kotlin.plugin.serialization"

    const val RETROFIT =  "com.squareup.retrofit2:retrofit:${NetworkVersions.RETROFIT}"
    const val LOGGING_INTERCEPTOR =  "com.squareup.okhttp3:logging-interceptor:${NetworkVersions.LOGGING_INTERCEPTOR}"
    const val RETROFIT_RX_JAVA_2 = "com.squareup.retrofit2:adapter-rxjava2:latest.version:${NetworkVersions.RETROFIT}"
    const val RETROFIT_SERIALIZATION = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${NetworkVersions.RETROFIT_SERIALIZATION}"
    const val SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-json:${NetworkVersions.SERIALIZATION}"
}
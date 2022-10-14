private object PresentationsVersions {

    const val APP_COMPAT = "1.5.1"
    const val MATERIAL = "1.6.1"
    const val CONSTRAINT = "2.1.4"
    const val SWIPE_REFRESH = "1.1.0"
    const val GLIDE = "4.13.2"

    const val SHIMMER = "0.5.0"

    // Lifecycl
    const val LIFECYCLE = "2.5.1"

    // Navigation
    const val NAVIGATION = "2.5.2"

    const val GROUPIE = "2.9.0"
}


object PresentationsDependency {

    const val APP_COMPAT = "androidx.appcompat:appcompat:${PresentationsVersions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${PresentationsVersions.MATERIAL}"
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${PresentationsVersions.CONSTRAINT}"

    const val SHIMMER = "com.facebook.shimmer:shimmer:${PresentationsVersions.SHIMMER}"

    // Navigation
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${PresentationsVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${PresentationsVersions.NAVIGATION}"

    // Lifecycle
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${PresentationsVersions.LIFECYCLE}"

    const val GLIDE = "com.github.bumptech.glide:glide:${PresentationsVersions.GLIDE}"
    const val KAPT_GLIDE = "com.github.bumptech.glide:compiler:${PresentationsVersions.GLIDE}"

    const val GROUPIE = "com.github.lisawray.groupie:groupie:${PresentationsVersions.GROUPIE}"
    const val GROUPIE_BINDING = "com.github.lisawray.groupie:groupie-viewbinding:${PresentationsVersions.GROUPIE}"
}

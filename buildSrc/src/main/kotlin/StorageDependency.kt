private object StorageVersion {

    const val ROOM = "2.4.3"
}

object StorageDependency {

    const val KAPT_ROOM = "androidx.room:room-compiler:${StorageVersion.ROOM}"

    const val ROOM = "androidx.room:room-runtime:${StorageVersion.ROOM}"
    const val ROOM_RX_JAVA2 = "androidx.room:room-rxjava2:${StorageVersion.ROOM}"
}
package org.disf.app.hammer_system.presentation.base.model

import org.disf.app.hammer_system.presentation.base.Event

data class ShowSnackBarEvent(
    val message: String,
) : Event

package org.disf.app.hammer_system.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

abstract class BaseViewModel <S: ViewState> : ViewModel() {

    val stateFlow: BehaviorSubject<S> = BehaviorSubject.create()

    val eventFlow: PublishSubject<Event> = PublishSubject.create()

    private val compositeDisposable = CompositeDisposable()

    protected val state: S
    get() = requireNotNull(stateFlow.value)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}

interface ViewState

interface Event
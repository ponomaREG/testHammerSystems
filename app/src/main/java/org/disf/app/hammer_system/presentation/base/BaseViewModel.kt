package org.disf.app.hammer_system.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

abstract class BaseViewModel<S : ViewState> : ViewModel() {

    abstract val initialState: S

    val stateFlow: BehaviorSubject<S> = BehaviorSubject.create()

    val eventFlow: PublishSubject<Event> = PublishSubject.create()

    protected val compositeDisposable = CompositeDisposable()

    protected val state: S?
        get() = stateFlow.value

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    protected fun submitState(transform: S.() -> S) {
        if (state == null) stateFlow.onNext(initialState.transform())
        else stateFlow.onNext(state!!.transform())
    }

    protected fun submitEvent(event: Event) {
        eventFlow.onNext(event)
    }
}

interface ViewState

interface Event
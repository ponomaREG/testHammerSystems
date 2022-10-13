package org.disf.app.hammer_system.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable
import org.disf.app.hammer_system.presentation.base.model.NavigationEvent
import org.disf.app.hammer_system.presentation.ext.addTo

abstract class BaseFragment<B : ViewBinding, S : ViewState, V : BaseViewModel<S>> : Fragment() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var _binding: B? = null
    private val binding: B
        get() = requireNotNull(_binding)

    abstract val viewModel: V

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): View
    abstract fun collectState(state: S)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initBinding(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.stateFlow.subscribe(this::collectState).addTo(compositeDisposable)
        viewModel.eventFlow.subscribe(this::collectEvent).addTo(compositeDisposable)
    }

    private fun collectEvent(event: Event) {
        when (event) {
            is NavigationEvent -> {
               findNavController().navigate(event.actionId)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
        _binding = null
    }
}
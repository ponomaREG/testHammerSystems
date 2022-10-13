package org.disf.app.hammer_system.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import org.disf.app.hammer_system.presentation.base.model.NavigationEvent
import org.disf.app.hammer_system.presentation.base.model.ShowSnackBarEvent
import org.disf.app.hammer_system.presentation.ext.addTo

abstract class BaseFragment<B : ViewBinding, S : ViewState, V : BaseViewModel<S>> : Fragment() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected var _binding: B? = null
    protected val binding: B
        get() = requireNotNull(_binding)

    abstract val viewModel: V

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): View
    abstract fun prepareView()
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
        prepareView()
        viewModel.stateFlow.subscribe(this::collectState).addTo(compositeDisposable)
        viewModel.eventFlow.subscribe(this::collectEvent).addTo(compositeDisposable)
    }

    private fun collectEvent(event: Event) {
        when (event) {
            is NavigationEvent -> {
                findNavController().navigate(event.actionId)
            }
            is ShowSnackBarEvent -> {
                Snackbar.make(binding.root, event.message, Snackbar.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
        _binding = null
    }
}
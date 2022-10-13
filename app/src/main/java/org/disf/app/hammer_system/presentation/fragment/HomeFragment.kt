package org.disf.app.hammer_system.presentation.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import org.disf.app.hammer_system.databinding.FragmentHomeBinding
import org.disf.app.hammer_system.presentation.base.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewState, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    private val foodAdapter: GroupAdapter<GroupieViewHolder> = GroupAdapter()
    private val bannerAdapter: GroupAdapter<GroupieViewHolder> = GroupAdapter()
    private val categoryAdapter: GroupAdapter<GroupieViewHolder> = GroupAdapter()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun prepareView() = with(binding) {
        foodListRv.adapter = foodAdapter
        foodListRv.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        bannerListRv.adapter = bannerAdapter
        categoryListRv.adapter = categoryAdapter
    }

    override fun collectState(state: HomeViewState) = with(binding) {
        loadingIndicatorFoodsSfl.root.isVisible = state.isLoadingFoods
        if (state.isLoadingFoods && !loadingIndicatorFoodsSfl.root.isShimmerStarted) loadingIndicatorFoodsSfl.root.startShimmer()
        if (!state.isLoadingFoods && loadingIndicatorFoodsSfl.root.isShimmerStarted) loadingIndicatorFoodsSfl.root.stopShimmer()

        loadingIndicatorCategoriesSfl.root.isVisible = state.isLoadingCategories
        if (state.isLoadingCategories && !loadingIndicatorCategoriesSfl.root.isShimmerStarted) loadingIndicatorCategoriesSfl.root.startShimmer()
        if (!state.isLoadingCategories && loadingIndicatorCategoriesSfl.root.isShimmerStarted) loadingIndicatorCategoriesSfl.root.stopShimmer()

        loadingIndicatorBannersSfl.root.isVisible = state.isLoadingBanners
        if (state.isLoadingBanners && !loadingIndicatorBannersSfl.root.isShimmerStarted) loadingIndicatorBannersSfl.root.startShimmer()
        if (!state.isLoadingBanners && loadingIndicatorBannersSfl.root.isShimmerStarted) loadingIndicatorBannersSfl.root.stopShimmer()

        cityNameTv.text = state.city
        if (state.foods.isNotEmpty()) foodAdapter.updateAsync(state.foods)
        if (state.banners.isNotEmpty()) bannerAdapter.updateAsync(state.banners)
        if (state.categories.isNotEmpty()) categoryAdapter.updateAsync(state.categories)
    }
}
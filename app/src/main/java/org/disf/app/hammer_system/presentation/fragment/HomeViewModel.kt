package org.disf.app.hammer_system.presentation.fragment

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.disf.app.hammer_system.domain.model.Banner
import org.disf.app.hammer_system.domain.model.Category
import org.disf.app.hammer_system.domain.model.Food
import org.disf.app.hammer_system.domain.repository.FoodRepository
import org.disf.app.hammer_system.presentation.base.BaseViewModel
import org.disf.app.hammer_system.presentation.base.ViewState
import org.disf.app.hammer_system.presentation.base.model.ShowSnackBarEvent
import org.disf.app.hammer_system.presentation.ext.addTo
import org.disf.app.hammer_system.presentation.item.BannerItem
import org.disf.app.hammer_system.presentation.item.CategoryItem
import org.disf.app.hammer_system.presentation.item.FoodItem
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodRepository: FoodRepository,
) : BaseViewModel<HomeViewState>() {

    override val initialState: HomeViewState = HomeViewState()

    init {
        loadCategories()
        loadFoods()
        loadBanners()
    }

    private fun onCategoryClicked(category: Category) {
        val currentCategories = requireNotNull(state?.categories)
        submitState {
            copy(
                categories = currentCategories.map { categoryItem ->
                    categoryItem.copy(isCategoryChecked = category.title == categoryItem.category.title)
                }
            )
        }
    }

    private fun onItemClicked(item: Food) {
        submitEvent(ShowSnackBarEvent(item.toString()))
    }

    private fun onBannerClicked(banner: Banner) {
        submitEvent(ShowSnackBarEvent(banner.toString()))
    }

    private fun loadCategories() {
        submitState { copy(isLoadingCategories = true) }
        foodRepository.loadCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data, error ->
                if (error == null) {
                    submitState {
                        copy(
                            categories = data.mapIndexed { index, category ->
                                CategoryItem(
                                    category,
                                    isCategoryChecked = index == 0,
                                    onItemClicked = this@HomeViewModel::onCategoryClicked
                                )
                            },
                            isLoadingCategories = false,
                        )
                    }
                } else Log.e("error", error.stackTraceToString())
            }.addTo(compositeDisposable)
    }

    private fun loadFoods() {
        submitState { copy(isLoadingFoods = true) }
        foodRepository.loadFoods()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    submitState {
                        copy(
                            foods = data.map {
                                FoodItem(
                                    it,
                                    onItemClicked = this@HomeViewModel::onItemClicked
                                )
                            },
                            isLoadingFoods = false,
                        )
                    }
                },
                { Log.e("error", it.stackTraceToString()) },
            ).addTo(compositeDisposable)
    }

    private fun loadBanners() {
        submitState { copy(isLoadingBanners = true) }
        foodRepository.loadBanners()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data, error ->
                if (error == null) {
                    submitState {
                        copy(
                            banners = data.map {
                                BannerItem(
                                    it,
                                    onItemClicked = this@HomeViewModel::onBannerClicked
                                )
                            },
                            isLoadingBanners = false,
                        )
                    }
                } else Log.e("error", error.stackTraceToString())
            }.addTo(compositeDisposable)
    }
}

data class HomeViewState(
    val city: String = "Москва",
    val isLoadingFoods: Boolean = false,
    val isLoadingCategories: Boolean = false,
    val isLoadingBanners: Boolean = false,
    val isError: Boolean = false,
    val foods: List<FoodItem> = listOf(),
    val categories: List<CategoryItem> = listOf(),
    val banners: List<BannerItem> = listOf()
) : ViewState
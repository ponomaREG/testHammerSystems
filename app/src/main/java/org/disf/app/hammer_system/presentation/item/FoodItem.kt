package org.disf.app.hammer_system.presentation.item

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import org.disf.app.hammer_system.R
import org.disf.app.hammer_system.databinding.ItemFoodBinding
import org.disf.app.hammer_system.domain.model.Food
import org.disf.app.hammer_system.presentation.ext.load

class FoodItem(
    private val food: Food,
    private val onItemClicked: (Food) -> Unit
) : BindableItem<ItemFoodBinding>() {

    override fun bind(viewBinding: ItemFoodBinding, position: Int) = with(viewBinding) {
        avatarIv.load(food.imageSrc)
        titleTv.text = food.title
        descriptionTv.text = food.description
        root.setOnClickListener {
            onItemClicked.invoke(food)
        }
    }

    override fun getLayout(): Int = R.layout.item_food

    override fun initializeViewBinding(view: View): ItemFoodBinding = ItemFoodBinding.bind(view)
}
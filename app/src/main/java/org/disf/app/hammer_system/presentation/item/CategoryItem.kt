package org.disf.app.hammer_system.presentation.item

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import org.disf.app.hammer_system.R
import org.disf.app.hammer_system.databinding.ItemCategoryBinding
import org.disf.app.hammer_system.domain.model.Category

data class CategoryItem(
    val category: Category,
    val isCategoryChecked: Boolean,
    private val onItemClicked: (Category) -> Unit
) : BindableItem<ItemCategoryBinding>() {

    override fun getId(): Long {
        return category.id.toLong()
    }

    override fun bind(viewBinding: ItemCategoryBinding, position: Int) = with(viewBinding.root) {
        text = category.title
        isChecked = isCategoryChecked
        setOnClickListener { onItemClicked.invoke(category) }
    }

    override fun getLayout(): Int = R.layout.item_category

    override fun initializeViewBinding(view: View): ItemCategoryBinding =
        ItemCategoryBinding.bind(view)
}
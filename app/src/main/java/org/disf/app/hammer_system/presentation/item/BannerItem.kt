package org.disf.app.hammer_system.presentation.item

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import org.disf.app.hammer_system.R
import org.disf.app.hammer_system.databinding.ItemBannerBinding
import org.disf.app.hammer_system.domain.model.Banner
import org.disf.app.hammer_system.presentation.ext.load

class BannerItem(
    private val banner: Banner,
    private val onItemClicked: (Banner) -> Unit
) : BindableItem<ItemBannerBinding>() {

    override fun getId(): Long {
        return banner.id.toLong()
    }

    override fun bind(viewBinding: ItemBannerBinding, position: Int) = with(viewBinding) {
        root.load(banner.bannerSrc)
        root.setOnClickListener {
            onItemClicked.invoke(banner)
        }
    }

    override fun getLayout(): Int = R.layout.item_banner

    override fun initializeViewBinding(view: View): ItemBannerBinding = ItemBannerBinding.bind(view)
}
package com.flareline.redox.items

import net.minecraft.item.Item

/**
 * A test item.
 */
class ElementX: Item(Settings().maxCount(64).group(ItemGroups.Elements)) {
	companion object {
		val Item: ElementX = ElementX()
	}
}

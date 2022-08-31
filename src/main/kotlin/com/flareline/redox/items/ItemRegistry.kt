package com.flareline.redox.items

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * The namespace to use for items in Redox.
 */
const val ITEM_NAMESPACE: String = "redox"

/**
 * Item registry to handle Redox item registration.
 */
class ItemRegistry {
	companion object {
		/**
		 * Register the mod's items.
		 */
		fun registerItems() {
			Registry.register(Registry.ITEM, Identifier(ITEM_NAMESPACE, "element_x"), ElementX.Item)
		}
	}
}

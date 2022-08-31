package com.flareline.redox.items

import com.flareline.redox.MOD_ID
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

/**
 * The [ItemGroup] instances to use in Redox.
 */
class ItemGroups {
	companion object {
		/**
		 * The [ItemGroup] to use for Element items.
		 */
		val Elements: ItemGroup = FabricItemGroupBuilder.build(Identifier(MOD_ID, "redox_elements")) { ItemStack(ElementX.Item) }
	}
}

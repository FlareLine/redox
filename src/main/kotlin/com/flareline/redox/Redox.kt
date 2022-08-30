package com.flareline.redox

import net.fabricmc.api.ModInitializer
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

@Suppress("unused")
class Redox: ModInitializer {

	private val testItem = Item(Item.Settings().group(ItemGroup.MISC))

	override fun onInitialize() {
		println("Initializing Redox.")
		Registry.register(Registry.ITEM, Identifier("redox", "test_item"), testItem)
	}
}

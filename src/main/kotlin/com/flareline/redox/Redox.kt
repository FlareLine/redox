package com.flareline.redox

import com.flareline.redox.items.ItemRegistry
import net.fabricmc.api.ModInitializer

const val MOD_ID: String = "redox"

@Suppress("unused")
object Redox: ModInitializer {
	override fun onInitialize() {
		println("Initializing Redox.")
		ItemRegistry.registerItems()
	}
}

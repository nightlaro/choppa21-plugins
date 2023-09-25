package net.unethicalite.plugins.example_kotlin

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigItem

interface ExampleKotlinPluginConfig : Config {
    @ConfigItem(keyName = "superCombatAmount", name = "Super Combat Amount", description = "")
    fun superCombatAmount(): Int? {
        return 1
    }
}
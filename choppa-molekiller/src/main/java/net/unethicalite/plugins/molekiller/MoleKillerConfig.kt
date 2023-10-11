package net.unethicalite.plugins.molekiller

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem

@ConfigGroup("molekiller")
interface MoleKillerConfig : Config {
    @ConfigItem(keyName = "superCombatAmount", name = "Super Combat Amount", description = "")
    fun superCombatAmount(): Int? {
        return 1
    }
}
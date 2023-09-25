package net.unethicalite.plugins.example_kotlin

import net.runelite.api.events.ChatMessage
import net.runelite.api.events.GameTick
import net.runelite.client.chat.ChatMessageBuilder
import net.runelite.client.chat.ChatMessageManager
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.PluginDescriptor
import net.unethicalite.api.plugins.LoopedPlugin
import net.unethicalite.api.widgets.Prayers
import org.pf4j.Extension

@PluginDescriptor(name = "Example Kotlin Plugin")
@Extension
class ExampleKotlinPlugin : LoopedPlugin() {
    override fun loop(): Int {
        return 2000
    }

    @Subscribe
    fun onGameTick(event: GameTick?) {
        ChatMessageBuilder().append("Game Tick $event").build()
        Prayers.toggleQuickPrayer(true)
        Prayers.toggleQuickPrayer(false)
    }
}
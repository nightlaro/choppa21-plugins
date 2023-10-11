package net.unethicalite.plugins.molekiller

import lombok.extern.slf4j.Slf4j
import net.runelite.api.ItemID
import net.runelite.api.Prayer
import net.runelite.api.Skill
import net.runelite.api.events.GameTick
import net.runelite.client.chat.ChatColorType
import net.runelite.client.chat.ChatMessageBuilder
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.PluginDescriptor
import net.runelite.client.plugins.skillcalculator.skills.MagicAction
import net.unethicalite.api.items.Equipment
import net.unethicalite.api.items.Inventory
import net.unethicalite.api.items.Items
import net.unethicalite.api.magic.Magic
import net.unethicalite.api.magic.Spell
import net.unethicalite.api.magic.SpellBook
import net.unethicalite.api.plugins.LoopedPlugin
import net.unethicalite.api.utils.MessageUtils
import net.unethicalite.api.widgets.Prayers
import net.unethicalite.client.Static
import org.pf4j.Extension

@Extension
@PluginDescriptor(name = "Choppa Molekiller")
class MoleKiller : LoopedPlugin() {
    private val client = Static.getClient()
    override fun loop(): Int {
        MessageUtils.addMessage("On Plugin - magic level ${client.getRealSkillLevel(Skill.MAGIC)}", ChatColorType.HIGHLIGHT)
        if (!Inventory.contains(ItemID.LAW_RUNE)) return 10000
        when (client.getRealSkillLevel(Skill.MAGIC)) {
            in 1..44 -> Magic.cast(SpellBook.Standard.FALADOR_TELEPORT)
            else -> Magic.cast(SpellBook.Standard.CAMELOT_TELEPORT)
        }
        return 1000
    }

    @Subscribe
    fun onGameTick(event: GameTick?) {
        if (!Inventory.contains(ItemID.NATURE_RUNE)) return
        if (!Inventory.contains(856)) return
        Magic.cast(SpellBook.Standard.HIGH_LEVEL_ALCHEMY, Inventory.getFirst(856))
    }
}
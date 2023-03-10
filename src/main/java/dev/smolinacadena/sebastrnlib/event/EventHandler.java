package dev.smolinacadena.sebastrnlib.event;

import dev.smolinacadena.sebastrnlib.SebastrnLib;
import dev.smolinacadena.sebastrnlib.config.ConfigHandler;
import dev.smolinacadena.sebastrnlib.network.client.SendChatMessage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = SebastrnLib.ID)
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (!ConfigHandler.SERVER.disableThanksMessage.get())
            SebastrnLib.channel.send(PacketDistributor.PLAYER.with(
                            () -> (ServerPlayer) event.getPlayer()),
                    new SendChatMessage());
    }
}

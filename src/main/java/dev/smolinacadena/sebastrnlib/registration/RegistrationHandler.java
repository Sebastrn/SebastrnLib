package dev.smolinacadena.sebastrnlib.registration;

import dev.smolinacadena.sebastrnlib.SebastrnLib;
import dev.smolinacadena.sebastrnlib.network.client.SendChatMessage;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SebastrnLib.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistrationHandler {

    public static void registerPackets() {
        var index = 0;

        SebastrnLib.channel.registerMessage(index++, SendChatMessage.class, SendChatMessage::encode, SendChatMessage::decode, SendChatMessage::onMessage);
    }
}

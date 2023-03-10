package dev.smolinacadena.sebastrnlib.network.client;

import dev.smolinacadena.sebastrnlib.config.ConfigHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SendChatMessage {

    public SendChatMessage() {
    }

    public static void encode(SendChatMessage message, FriendlyByteBuf packet) {
    }

    public static SendChatMessage decode(FriendlyByteBuf packet) {
        return new SendChatMessage();
    }

    public static void onMessage(SendChatMessage packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (!ConfigHandler.CLIENT.sayThanksMessage.get())
                return;

            MutableComponent message = new TextComponent("[")
                    .append(new TextComponent("SebastrnLib").withStyle(ChatFormatting.GOLD))
                    .append(new TextComponent("] "))
                    .append(new TranslatableComponent("messages.sebastrnlib.thanks1"))
                    .append(new TranslatableComponent("item.sebastrnlib.book"))
                    .append(new TranslatableComponent("messages.sebastrnlib.thanks2"));

            Minecraft.getInstance().player.sendMessage(message, Util.NIL_UUID);
        });

        ctx.get().setPacketHandled(true);
    }
}
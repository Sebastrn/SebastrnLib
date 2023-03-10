package dev.smolinacadena.sebastrnlib.network.client;

import dev.smolinacadena.sebastrnlib.config.ConfigHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
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

            MutableComponent message = Component.literal("[")
                    .append(Component.literal("SebastrnLib").withStyle(ChatFormatting.GOLD))
                    .append(Component.literal("] "))
                    .append(Component.translatable("messages.sebastrnlib.thanks1"))
                    .append(Component.translatable("item.sebastrnlib.book"))
                    .append(Component.translatable("messages.sebastrnlib.thanks2"));

            Minecraft.getInstance().player.sendSystemMessage(message);
        });

        ctx.get().setPacketHandled(true);
    }
}
package dev.smolinacadena.sebastrnlib.config;

import dev.smolinacadena.sebastrnlib.SebastrnLib;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = SebastrnLib.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHandler {

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    static {
        Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
        Pair<Server, ForgeConfigSpec> serverSpecPair = new ForgeConfigSpec.Builder().configure(Server::new);

        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
        SERVER_SPEC = serverSpecPair.getRight();
        SERVER = serverSpecPair.getLeft();
    }

    public static class Client {
        public ForgeConfigSpec.BooleanValue sayThanksMessage;

        Client(ForgeConfigSpec.Builder builder) {
            //@formatter:off
            sayThanksMessage = builder
                    .comment("Display a thank you message at spawn?")
                    .define("sayThanksMessage", true);
        }
    }

    public static class Server {
        public ForgeConfigSpec.BooleanValue disableThanksMessage;

        Server(ForgeConfigSpec.Builder builder) {
            //@formatter:off
            disableThanksMessage = builder
                    .comment("Set this to true to disable sending the thank you message that SebastrnLib shows when a player joins.",
                            "Note, that this stops showing the message for every player, even those that want to see them.")
                    .define("disable_thanks_message", false);
        }
    }
}

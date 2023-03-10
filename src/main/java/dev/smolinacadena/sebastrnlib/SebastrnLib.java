package dev.smolinacadena.sebastrnlib;

import dev.smolinacadena.sebastrnlib.config.ConfigHandler;
import dev.smolinacadena.sebastrnlib.registration.RegistrationHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod(SebastrnLib.ID)
@Mod.EventBusSubscriber(modid = SebastrnLib.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class SebastrnLib {
    public static final String ID = "sebastrnlib";
    public static SimpleChannel channel = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(SebastrnLib.ID, SebastrnLib.ID),
            () -> SebastrnLib.getVersion(),
            SebastrnLib.getVersion()::equals,
            SebastrnLib.getVersion()::equals);

    public SebastrnLib() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigHandler.CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigHandler.SERVER_SPEC);
    }

    @SubscribeEvent
    public static void onFMLCommonSetup(FMLCommonSetupEvent event) { //stage 1
        RegistrationHandler.registerPackets();
    }

    public static String getVersion() {
        return "v" + ModList.get().getModContainerById(ID).get().getModInfo().getVersion().toString();
    }
}

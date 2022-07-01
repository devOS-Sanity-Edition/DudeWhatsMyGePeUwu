package one.devos.nautical.dudewhatsmygepeuwu.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DudeWhatsMyGePeUwuClient implements ClientModInitializer {
    public static final String MOD_ID = "dudewhatsmygepeuwu";
    public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().getFriendlyString();
    public static final String MOD_NAME = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getName();

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);


    @Override
    public void onInitializeClient() {
        LOGGER.info("[" + MOD_NAME + "] Version " + VERSION + " loaded." );
        LOGGER.info("[" + MOD_NAME + "] " + "GPU ready to be obliterated");
    }
}

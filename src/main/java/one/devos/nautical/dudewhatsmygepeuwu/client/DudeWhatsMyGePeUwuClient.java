package one.devos.nautical.dudewhatsmygepeuwu.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DudeWhatsMyGePeUwuClient implements ClientModInitializer {
    public static final String MOD_ID = "dudewhatsmygepeuwu";
    public static final Logger LOGGER = LoggerFactory.getLogger("Dude, Whats My GePeUwu");

    @Override
    public void onInitializeClient() {

        LOGGER.info("GPU ready to be obliterated");
    }
}

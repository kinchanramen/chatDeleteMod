package net.kinchanramen.github.chatdeletemod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatDeleteMod implements ModInitializer {
    private static final String CONFIG_NAME="chatDeleteModConfig.json";
    public static Logger logger;

    @Override
    public void onInitialize() {
        logger= LoggerFactory.getLogger("ChatDeleteMod");
        logger.info("Initializing ChatDeleteMod");
    }
    public static String getConfigName(){return CONFIG_NAME;}
}

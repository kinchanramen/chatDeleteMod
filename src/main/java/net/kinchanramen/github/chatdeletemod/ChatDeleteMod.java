package net.kinchanramen.github.chatdeletemod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatDeleteMod implements ModInitializer {
    private static final String MOD_ID="chatdeletemod";
    private static final String CONFIG_NAME="chatDeleteModConfig.json";
    private static final String CONFIG_FILENAME="chatDeleteMod";
    public static Logger logger;

    @Override
    public void onInitialize() {
        logger= LoggerFactory.getLogger("ChatDeleteMod");
        logger.info("ChatDeleteMod is initializing");
    }
    public static String getConfigName(){return CONFIG_NAME;}
    public static String getConfigFileName(){return CONFIG_FILENAME;}
}

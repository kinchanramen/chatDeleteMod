package net.kinchanramen.github.chatdeletemod.ModMenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.kinchanramen.github.chatdeletemod.ChatDeleteModClothConfig;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory(){
        return ChatDeleteModClothConfig::getConfigScreen;
    }
}

package net.kinchanramen.github.chatdeletemod;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
public class ChatDeleteModClothConfig {
    public static Screen getConfigScreen(Screen parent){
        ChatDeleteModConfig.loadConfig();
        ConfigBuilder builder=ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.of("ChatDeleteMod Config"));
        ConfigEntryBuilder entryBuilder=builder.entryBuilder();
        ConfigCategory general=builder.getOrCreateCategory(Text.of("General"));

        general.addEntry(entryBuilder.startStrList(Text.of("CensoredWords"),ChatDeleteModConfig.getCensoredWords())
                .setSaveConsumer(ChatDeleteModConfig::setCensoredWords)
                .build());
        builder.setSavingRunnable(ChatDeleteModConfig::saveConfig);
        return builder.build();
    }
}

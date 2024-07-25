package net.kinchanramen.github.chatdeletemod.client;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.kinchanramen.github.chatdeletemod.ChatDeleteModConfig;
import net.kinchanramen.github.chatdeletemod.command.ChatDeleteModCommand;
import net.minecraft.command.CommandRegistryAccess;

public class ChatDeleteModClient implements ClientModInitializer {
    public static ChatDeleteModConfig config;
    @Override
    public void onInitializeClient() {
        config=new ChatDeleteModConfig();
        config.loadConfig();
        ClientCommandRegistrationCallback.EVENT.register(this::registerCommands);
    }
    public void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess){
        ChatDeleteModCommand.register(dispatcher);
    }
}

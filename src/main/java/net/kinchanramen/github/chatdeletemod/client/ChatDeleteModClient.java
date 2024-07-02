package net.kinchanramen.github.chatdeletemod.client;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.kinchanramen.github.chatdeletemod.ChatDeleteMod;
import net.kinchanramen.github.chatdeletemod.command.ChatDeleteModCommand;
import net.minecraft.command.CommandRegistryAccess;

public class ChatDeleteModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(this::registerCommands);
    }
    public void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess){
        ChatDeleteModCommand.register(dispatcher);
    }
}

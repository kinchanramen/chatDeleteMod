package net.kinchanramen.github.chatdeletemod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;

public class ChatDeleteModCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("ChatDeleteMod")
                .then(ClientCommandManager.argument("message", StringArgumentType.string())
                .executes(context -> {
                    final String message = StringArgumentType.getString(context, "message");
                    System.out.println(message);
                    return 0;
                })));
    }

    private static int DeleteMessageregister(CommandContext<FabricClientCommandSource> Context, Text value) {
        Context.getSource().sendFeedback(value);
        return 0;
    }
}
package net.kinchanramen.github.chatdeletemod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.kinchanramen.github.chatdeletemod.ChatDeleteModConfig;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;

import java.util.List;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.kinchanramen.github.chatdeletemod.client.ChatDeleteModClient.config;

public class ChatDeleteModCommand {
    private static final SuggestionProvider<FabricClientCommandSource> CENSORED_WORDS_SUGGESTION_PROVIDER = (context, builder) -> {
        // `ChatDeleteMod.getCensoredWords()` で設定された censoredWords リストを取得
        List<String> censoredWords = ChatDeleteModConfig.getCensoredWords();

        for (String word : censoredWords) {
            builder.suggest(word);
        }

        return builder.buildFuture();
    };
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(ClientCommandManager.literal("ChatDeleteMod")
                .then(ClientCommandManager.literal("add")
                        .then(ClientCommandManager.argument("word", StringArgumentType.greedyString())
                                .executes(context -> addCensoreWord(context.getSource(), StringArgumentType.getString(context, "word")))))
                .then(ClientCommandManager.literal("remove")
                        .then(ClientCommandManager.argument("word", StringArgumentType.greedyString())
                                .suggests(CENSORED_WORDS_SUGGESTION_PROVIDER)
                                .executes(context -> removeCensoreWord(context.getSource(), StringArgumentType.getString(context, "word")))))
                .then(ClientCommandManager.literal("removeall")
                        .executes(context -> removeAllCensoreWords(context.getSource())))
                .then(ClientCommandManager.literal("list")
                        .executes(context -> listCensoreWords(context.getSource()))));
    }
    private static int addCensoreWord(FabricClientCommandSource source, String word) {
        List<String> words = ChatDeleteModConfig.getCensoredWords();
        if (!words.contains(word)) {
            words.add(word);
            config.setCensoredWords(words);
            source.sendFeedback(Text.literal("Added censored word: " + word));
        } else {
            source.sendFeedback(Text.literal("Word already in censored list: " + word));
        }
        return 1;
    }
    private static int removeCensoreWord(FabricClientCommandSource source, String word) {
        List<String> words = ChatDeleteModConfig.getCensoredWords();
        if (words.contains(word)) {
            words.remove(word);
            config.setCensoredWords(words);
            source.sendFeedback(Text.literal("Removed censored word: " + word));
        } else {
            source.sendFeedback(Text.literal("Word not found in censored list: " + word));
        }
        return 1;
    }
    private static int removeAllCensoreWords(FabricClientCommandSource source) {
        List<String> censoredWords = ChatDeleteModConfig.getCensoredWords();

        if (censoredWords.isEmpty()) {
            source.sendFeedback(Text.literal("Words not found in censored list."));
        } else {
            censoredWords.clear(); // censoredWords リストをクリア
            ChatDeleteModConfig.saveConfig(); // 設定ファイルを保存
            source.sendFeedback(Text.literal("All censored words have been removed."));
        }

        return 1;
    }
    private static int listCensoreWords(FabricClientCommandSource source) {
        List<String> words = ChatDeleteModConfig.getCensoredWords();
        if (words.isEmpty()) {
            source.sendFeedback(Text.literal("No censored words found."));
        } else {
            source.sendFeedback(Text.literal("Censored words: " + String.join(", ", words)));
        }
        return 1;
    }

    private static int DeleteMessageregister(CommandContext<FabricClientCommandSource> Context, Text value) {
        Context.getSource().sendFeedback(value);
        return 0;
    }
}
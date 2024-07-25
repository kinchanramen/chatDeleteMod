package net.kinchanramen.github.chatdeletemod;

import net.fabricmc.loader.api.FabricLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDeleteModConfig {
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().resolve(ChatDeleteMod.getConfigName()).toUri());
    private static List<String> censoredWords;

    public ChatDeleteModConfig() {
        censoredWords = new ArrayList<>();
        loadConfig();
    }

    public static List<String> getCensoredWords() {
        return censoredWords;
    }

    public void setCensoredWords(List<String> censoredWords) {
        ChatDeleteModConfig.censoredWords = censoredWords;
        saveConfig();
    }

    public void loadConfig() {
        if (!CONFIG_FILE.exists()) {
            saveConfig(); // 初回実行時にデフォルト設定を保存
            return;
        }

        try (Reader reader = new FileReader(CONFIG_FILE)) {
            Gson gson = new Gson();
            censoredWords = gson.fromJson(reader, new TypeToken<List<String>>(){}.getType());
            if (censoredWords == null) {
                censoredWords = new ArrayList<>();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void saveConfig() {
        try (Writer writer = new FileWriter(CONFIG_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(censoredWords, writer);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}


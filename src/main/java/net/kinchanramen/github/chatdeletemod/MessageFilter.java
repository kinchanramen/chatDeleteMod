package net.kinchanramen.github.chatdeletemod;

import java.util.Arrays;
import java.util.List;

public class MessageFilter {
    private static final List<String> IGNORED_MESSAGES= Arrays.asList(
            "Added censored word: ",
            "Word already in censored list: ",
            "Censored words: ",
            "Removed censored word: ",
            "Word not found in censored list: ",
            "Words not found in censored list.",
            "All censored words have been removed."
    );
    public static boolean shouldIgnore(String message) {
        return IGNORED_MESSAGES.stream().anyMatch(message::startsWith);
    }

}

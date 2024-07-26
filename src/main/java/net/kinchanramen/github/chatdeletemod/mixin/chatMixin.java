package net.kinchanramen.github.chatdeletemod.mixin;

import net.kinchanramen.github.chatdeletemod.ChatDeleteModConfig;
import net.kinchanramen.github.chatdeletemod.MessageFilter;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.MessageIndicator;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ChatHud.class)
public class chatMixin {
    @Inject(method = "Lnet/minecraft/client/gui/hud/ChatHud;addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V",at = @At("HEAD"),cancellable = true)
    private void ChatDelete(Text message, MessageSignatureData signature, MessageIndicator indicator, CallbackInfo ci) {
        // メッセージを文字列として取得
        String messageString = message.getString();

        // "Added censored word: " で始まるメッセージを許可
        if (MessageFilter.shouldIgnore(messageString)) {
            return; // 処理をキャンセルせずにメッセージを表示
        }

        // censoredWords リストを取得
        List<String> censoredWords = ChatDeleteModConfig.getCensoredWords();

        // censoredWords に含まれる単語がメッセージに含まれているか確認
        for (String word : censoredWords) {
            if (messageString.contains(word)) {
                ci.cancel(); // メッセージをキャンセル
                return;
            }
        }
    }
}
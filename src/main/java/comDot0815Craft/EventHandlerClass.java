package comDot0815Craft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventHandlerClass implements Listener {

    @EventHandler
    void PlayerAsyncChatEvent(AsyncPlayerChatEvent chatEvent){
        String customPrefix = _30YearsPlugin.getChat().getPlayerPrefix(chatEvent.getPlayer());
        if(customPrefix != null && customPrefix.trim().length() > 0){
            chatEvent.setFormat(String.format("%s %s", customPrefix, "%s ➮ %s"));
            return;
        }
        chatEvent.setFormat("%s ➮ %s");
    }
}

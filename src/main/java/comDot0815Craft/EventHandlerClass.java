package comDot0815Craft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import java.lang.StringBuilder;

public class EventHandlerClass implements Listener {

    @EventHandler
    void PlayerAsyncChatEvent(AsyncPlayerChatEvent chatEvent){
        String customPrefix = _30YearsPlugin.getChat().getPlayerPrefix(chatEvent.getPlayer());
        if(customPrefix != null && customPrefix.trim().length() > 0){
            chatEvent.setFormat(String.format("%s %s", customPrefix, "%s ➮ %s"));
            return;
        }
        chatEvent.setFormat("%s ➮ %s");
        
        //rainbow color wenn nachricht mit $ anfängt
        if(chatEvent.getMessage().startsWith("$")) {
            chatEvent.setMessage(color(chatEvent.getMessage().substring(1)));
        }
    }
    
   private String color(String s) {
       char[] colors = new char[]{'4', '6', 'e', 'a', '2', 'b', '9', '5', 'd'};
        int i = -1;
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                builder.append(' ');
                continue;
            }
            i++;
            builder.append("§").append(colors[i]).append(c);
            if(i == 8) {
                i = -1;
            }
        }
        return builder.toString();
   }
    
    @EventHandler
    public void join(PlayerJoinEvent event) {
        event.setJoinMessage("§a" + event.getPlayer().getName() + " §1hat §c0815Craft §1betreten§e!");
    }
    
    @EventHandler
    public void quit(PlayerQuitEvent event) {
        event.setJoinMessage("§a" + event.getPlayer().getName() + " §1hat §c0815Craft §1verlassen§e!");
    }
}

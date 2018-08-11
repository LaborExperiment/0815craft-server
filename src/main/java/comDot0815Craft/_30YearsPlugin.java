package comDot0815Craft;

import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;

public class _30YearsPlugin extends JavaPlugin {

    private static Chat chat = null;

    @Override
    public void onEnable() {
        setupChat();
        getServer().getPluginManager().registerEvents(new EventHandlerClass(), this);
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static Chat getChat() {
        return chat;
    }
}


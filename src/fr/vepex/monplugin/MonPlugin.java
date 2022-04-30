package fr.vepex.monplugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MonPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("  _____  _             _       ____                 \r\n"
                + " |  __ \\| |           (_)     |  _ \\                \r\n"
                + " | |__) | |_   _  __ _ _ _ __ | |_) | __ _ ___  ___ \r\n"
                + " |  ___/| | | | |/ _` | | '_ \\|  _ < / _` / __|/ _ \\\r\n"
                + " | |    | | |_| | (_| | | | | | |_) | (_| \\__ \\  __/\r\n"
                + " |_|    |_|\\__,_|\\__, |_|_| |_|____/ \\__,_|___/\\___|\r\n"
                + "                  __/ |                             \r\n"
                + "                 |___/            "
                + "\r\n"
                + "Créé par Vepex le goat de twitter");
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        getServer().getPluginManager().registerEvents((Listener) new MonPluginListeners(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("[PluginBase] Le plugin vient de s'éteindre avec succès !");
    }
}

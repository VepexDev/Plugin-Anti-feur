package fr.vepex.monplugin;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MonPluginListeners implements Listener {
    private static Plugin plugin = JavaPlugin.getProvidingPlugin(MonPlugin.class);
    private boolean iquoi;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        if (message.endsWith("quoi") || message.endsWith("quoi ?") || message.endsWith("quoi?")) {
            Player player = e.getPlayer();
            e.setMessage(message);
            Bukkit.getScheduler().runTask(plugin, () -> player.sendMessage(plugin.getConfig().getString("message-quoi")));
            iquoi = true;
        } else {
            if(iquoi == true) {
                if (message.startsWith("feur")) {
                    Player player = e.getPlayer();
                    e.setMessage(message);
                    Bukkit.getScheduler().runTask(plugin, () -> player.kickPlayer(plugin.getConfig().getString("message-feur")));
                    Bukkit.getScheduler().runTask(plugin, () -> Bukkit.broadcastMessage(plugin.getConfig().getString("annonce-kick")));
                }
            }
            iquoi = false;
        }

        if (message.contains("poupou")) {
            Player player = e.getPlayer();
            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), plugin.getConfig().getString("easter-egg-ban"), null, "Vepex");
            Bukkit.getScheduler().runTask(plugin, () -> player.kickPlayer(plugin.getConfig().getString("easter-egg-kick")));
            Bukkit.broadcastMessage(plugin.getConfig().getString("easter-egg-annonce"));
        }
    }
}

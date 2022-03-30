package tk.trollagent.fly.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class trolljoin implements Listener {
    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        //This if I want to know if this plugin is used on your Server
        Player player = event.getPlayer();
        if (player.getName().equalsIgnoreCase("Trollagent")){
            player.sendMessage(ChatColor.GREEN + "Das Plugin SimpleFly ist auf diesem Server instaliert");
            return;
        }
    }
}

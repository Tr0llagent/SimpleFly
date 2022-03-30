package tk.trollagent.fly;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tk.trollagent.fly.commands.Fly;
import tk.trollagent.fly.events.trolljoin;

public final class SimpleFly extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new Fly());
        Bukkit.getPluginManager().registerEvents(new trolljoin(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

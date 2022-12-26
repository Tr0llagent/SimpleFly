package de.trollagent.fly;

import de.trollagent.fly.commands.Fly;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleFly extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new Fly());
    }

}

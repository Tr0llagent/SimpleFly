package de.trollagent.simplefly;

import de.trollagent.simplefly.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleFly extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand(this));
        saveDefaultConfig();
    }

}

package tk.trollagent.fly;

import org.bukkit.plugin.java.JavaPlugin;
import tk.trollagent.fly.commands.Fly;

public final class SimpleFly extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new Fly());
    }

}

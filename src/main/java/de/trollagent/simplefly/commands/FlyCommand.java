package de.trollagent.simplefly.commands;

import de.trollagent.simplefly.SimpleFly;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    private SimpleFly simpleFly;

    public FlyCommand(SimpleFly simpleFly) {
        this.simpleFly = simpleFly;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("non-player-message")));
        }

        Player player = (Player) sender;

        if (!player.hasPermission(simpleFly.getConfig().getString("fly-other-permission")) || !player.hasPermission(simpleFly.getConfig().getString("fly-other-permission"))) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("noperms-message")
                            .replace("%player%", player.getDisplayName())
                            .replace("%target%", args[0])));
            return true;
        }

        if (args.length > 1) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("usage-message")));
            return true;
        }

        if (args.length == 1) {

            if (!player.hasPermission(simpleFly.getConfig().getString("fly-other-permission"))) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        simpleFly.getConfig().getString("noperms-message")
                                .replace("%player%", player.getDisplayName())));
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        simpleFly.getConfig().getString("invalidplayer-message")
                                .replace("%player%", player.getDisplayName())
                                .replace("%target%", args[0])));
                return true;
            }

            if (target.getAllowFlight()) {
                target.setAllowFlight(false);
                target.setFlying(false);
                target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        simpleFly.getConfig().getString("fly-disabled-by-others-message")
                                .replace("%player%", player.getDisplayName())
                                .replace("%target%", args[0])));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        simpleFly.getConfig().getString("fly-disabled-for-others-message")
                                .replace("%player%", player.getDisplayName())
                                .replace("%target%", args[0])));
                return true;
            }

            target.setAllowFlight(true);
            target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("fly-enabled-by-others-message")
                            .replace("%player%", player.getDisplayName())
                            .replace("%target%", args[0])));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("fly-enabled-for-others-message")
                            .replace("%player%", player.getDisplayName())
                            .replace("%target%", args[0])));
            return true;

        }

        if (!player.hasPermission(simpleFly.getConfig().getString("fly-self-permission"))) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("noperms-message")
                            .replace("%player%", player.getDisplayName())));
            return true;
        }

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    simpleFly.getConfig().getString("fly-disabled-self-message")
                            .replace("%player%", player.getDisplayName())));
            return true;
        }

        player.setAllowFlight(true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                simpleFly.getConfig().getString("fly-enabled-self-message")
                        .replace("%player%", player.getDisplayName())));
        return true;
    }
}
package de.trollagent.fly.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {
                if (player.hasPermission("simplefly.fly.other")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (player.getServer().getPlayer(args[0]) != null) {
                        if (target.getAllowFlight() == true) {
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.RED + "Flight mode activated!");
                            sender.sendMessage(ChatColor.RED + "Flight mode deactivated for " + target.getDisplayName() + "!");
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.GREEN + "Flight mode activated!");
                            sender.sendMessage(ChatColor.GREEN + "Flight mode activated for " + target.getDisplayName() + "!");
                        }
                        return false;
                    } else {
                        sender.sendMessage(ChatColor.RED + "The Player is not Online");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "You dont have the Permission!");
                }
            } else if (args.length == 0) {
                if (player.hasPermission("simplefly.fly.self")) {
                    if (player.getAllowFlight() == true) {
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.RED + "Flight mode deactivated!");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.GREEN + "Flight mode activated!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "You dont have the Permission!");
                    return false;
                }
            }
            return false;
        }else {
            if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (sender.getServer().getPlayer(args[0]) != null) {
                        if (target.getAllowFlight() == true) {
                            target.setAllowFlight(false);
                            target.sendMessage(ChatColor.RED + "Flight mode deactivated!");
                            sender.sendMessage(ChatColor.RED + "Flight mode deactivated for " + target.getDisplayName() + "!");
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(ChatColor.GREEN + "Flight mode activated!");
                            sender.sendMessage(ChatColor.GREEN + "Flight mode activated for " + target.getDisplayName() + "!");
                        }
                        return false;
                    } else {
                        sender.sendMessage(ChatColor.RED + "The Player is not Online");
                    }
                } else {
                sender.sendMessage(ChatColor.RED + "The console can not fly, please type in a player name!");
                }
            }return false;

    }
}
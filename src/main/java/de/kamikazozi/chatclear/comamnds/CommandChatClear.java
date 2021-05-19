package de.kamikazozi.chatclear.comamnds;

import de.kamikazozi.chatclear.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Florian Dohms
 * <p>
 * Copyright (c) 2017 - 2020 by KamiKazozi to present. All rights served.
 */
public class CommandChatClear implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (args.length == 0) {
            if (sender.hasPermission("chatclear.help") || sender.hasPermission("chatclear.*")) {
                sender.sendMessage(Data.prefix + "§7Benutze: /chatclear <self | all | <spieler> >");
                return true;
            } else {
                sender.sendMessage(Data.noPerm);
            }
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("self")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(Data.onlyPlayer);
                    return true;
                }
                if (sender.hasPermission("chatclear.self") || sender.hasPermission("chatclear.*")) {
                    for (int i = 0; i < 150; i++) {
                        player.sendMessage("");
                    }
                    player.sendMessage(Data.prefix + "§aDer Chat wurde für dich gelöscht!");
                } else {
                    sender.sendMessage(Data.noPerm);
                }
            } else if (args[0].equalsIgnoreCase("all")) {
                if (sender.hasPermission("chatclear.all") || sender.hasPermission("chatclear.*")) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        for (int i = 0; i < 150; i++) {
                            players.sendMessage("");
                        }
                    }
                    Bukkit.broadcastMessage(Data.prefix + "§aDer Chat wurde für alle Spieler gelöscht!");
                } else {
                    sender.sendMessage(Data.noPerm);
                }
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(Data.noPlayer);
                    return true;
                }
                for (int i = 0; i < 150; i++) {
                    target.sendMessage("");
                }
                target.sendMessage(Data.prefix + "§aDein Chat wurde gelöscht!");
            }
        }
        return true;
    }
}

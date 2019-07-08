package me.ryder.crazywarps.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdCwReload implements CommandExecutor {

    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("cw reload")) {
            if (!p.hasPermission("cw.access")) {
               // p.sendMessage(Methods.pl(msg.getString("messages.prefix" + " messages.no-perms")));
                return true;
            }

            else {

               // p.sendMessage(Methods.pl(msg.getString("messages.prefix" + " messages.config-reload")));
            }
        }

        return true;
    }

}
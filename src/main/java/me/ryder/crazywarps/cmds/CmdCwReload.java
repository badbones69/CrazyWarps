package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdCwReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            return true;
        }

        if (!(p instanceof Player)) {
            p.sendMessage(Methods.getPrefix() + Methods.getConsole());
            return true;
        }

        if (!p.hasPermission("cw.access")) {
            p.sendMessage(Methods.getPrefix() + Methods.getPerms());
            return true;
        }

        else if (args[0].equals("reload")) {
            p.sendMessage(Methods.getPrefix() + Methods.getReload());
        }

        return true;
    }
}

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

            if (p.hasPermission("cw.access")) {
                p.sendMessage(Methods.getPrefix() + Methods.getPerms());
                return true;
            }

            if (!(p instanceof Player)) {
                p.sendMessage(Methods.pl("&c[&e!&c] This command can only be ran by a player."));
                return true;
            }

        } else {
            if (args[0].equalsIgnoreCase("reload")) {
                p.sendMessage(Methods.getPrefix() + Methods.getReload());
            }
        }
        return true;
    }
}

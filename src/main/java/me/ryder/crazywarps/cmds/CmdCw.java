package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdCw implements CommandExecutor {

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
        else if (args[0].equals("help")) {
            p.sendMessage(Methods.pl(Methods.getPrefix() + "&cThis shows a list of all available commands."));
            p.sendMessage(Methods.pl("&8- &c/cw reload &7This will reload the plugin."));
            p.sendMessage(Methods.pl("&8- &c/cw delwarp <warp name> &7This will delete a warp."));
            p.sendMessage(Methods.pl("&8- &c/cw setwarp <warp name> &7This will set a warp."));
            p.sendMessage(Methods.pl("&8- &c/cw warplist &7This will list all warps and categories."));
            p.sendMessage(Methods.pl("&8- &c/cw warpsync &7This will sync Essentials & CMI warps into CrazyWarps."));
        }
        return true;
    }
}

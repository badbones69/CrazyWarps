package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CmdCw implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {

            if (!(p instanceof Player)) {
               // p.sendMessage(Methods.pl(msg.getString("messages.prefix" + " &cYou can only use that command in-game.")));
                return true;
            }

            if (label.equalsIgnoreCase("cw")) {
                if (!p.hasPermission("cw.list")) {
                   // p.sendMessage(Methods.pl(msg.getString("messages.prefix" + "messages.no-perms")));
                    return true;
                }
                else {
                   // p.sendMessage(Methods.pl(msg.getString("messages.prefix" + " &cThis shows a list of all available commands.")));
                    p.sendMessage(Methods.pl("&8- &c/cw reload &7This will reload the plugin."));
                    p.sendMessage(Methods.pl("&8- &c/cw delwarp <warp name> &7This will delete a warp."));
                    p.sendMessage(Methods.pl("&8- &c/cw setwarp <warp name> &7This will set a warp."));
                    p.sendMessage(Methods.pl("&8- &c/cw warplist &7This will list all warps and categories."));
                    p.sendMessage(Methods.pl("&8- &c/cw warpsync &7This will sync Essentials & CMI warps into CrazyWarps."));
                }
            }
     return true;
    }
}

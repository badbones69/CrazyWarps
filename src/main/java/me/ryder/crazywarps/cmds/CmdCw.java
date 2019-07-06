package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.CrazyWarps;
import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.fm.Cortex;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdCw extends JavaPlugin implements CommandExecutor {
    
    private static Cortex instance = new Cortex();

    public boolean onCommand(CommandSender p, Command cmd, String commandLabel, String[] args) {
        

            if (!commandLabel.equalsIgnoreCase("cw")) {
                if (!p.hasPermission("cw.access")) {
                    p.sendMessage(Methods.pl(msg.getString("settings.prefix" + "&cYou do not nave enough permissions.")));
                    return true;
                }
                else {
                    p.sendMessage(Methods.pl(msg.getString("settings.prefix" + "&cThis shows a list of all available commands.")));
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

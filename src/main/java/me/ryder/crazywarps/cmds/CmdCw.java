package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.fm.Cortex;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdCw extends JavaPlugin implements CommandExecutor {

    public static Cortex settings = Cortex.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            FileConfiguration config = settings.getConfig();
            FileConfiguration msg = settings.getLang();

            if (!commandLabel.equalsIgnoreCase("cw")) {
                if (!sender.hasPermission("cw.access")) {
                    sender.sendMessage(Methods.pl(msg.getString("settings.prefix" + "&cYou do not nave enough permissions.")));
                    return true;
                }
                else {
                    sender.sendMessage(Methods.pl(msg.getString("settings.prefix" + "&cThis shows a list of all available commands.")));
                    sender.sendMessage(Methods.pl("&8- &c/cw reload &7This will reload the plugin."));
                    sender.sendMessage(Methods.pl("&8- &c/cw delwarp <warp name> &7This will delete a warp."));
                    sender.sendMessage(Methods.pl("&8- &c/cw setwarp <warp name> &7This will set a warp."));
                    sender.sendMessage(Methods.pl("&8- &c/cw warplist &7This will list all warps and categories."));
                    sender.sendMessage(Methods.pl("&8- &c/cw warpsync &7This will sync Essentials & CMI warps into CrazyWarps."));
                }
            }
     return true;
    }
}

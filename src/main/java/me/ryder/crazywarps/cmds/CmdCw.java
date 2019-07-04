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
                    sender.sendMessage(Methods.pl("&cYou do not have enough permissions."));
                    return true;
                }
                else {
                    sender.sendMessage(Methods.pl(msg.getString("settings.prefix" + "&cThis shows a list of all available commands.")));
                }
            }
     return true;
    }
}

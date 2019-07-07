package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.fm.SettingsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CmdCwReload extends JavaPlugin implements CommandExecutor {

    public static SettingsManager settings = SettingsManager.getInstance();

    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
        FileConfiguration msg = settings.getLang();

        if (label.equalsIgnoreCase("cw reload")) {
            if (!p.hasPermission("cw.access")) {
                p.sendMessage(Methods.pl(msg.getString("messages.prefix" + "messages.no-perms")));
                return true;
            }

            else {
                settings.reloadConfig();

                p.sendMessage(Methods.pl(msg.getString("messages.prefix" + "messages.config-reload")));
            }
        }

        return true;
    }

}
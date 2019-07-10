package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.fm.FileManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdCwReload implements CommandExecutor {

    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("cw reload")) {
            if (!p.hasPermission("cw.access")) {
                p.sendMessage(Methods.getPrefix() + Methods.getPerms());
                return true;
            }

            else {
                p.sendMessage(Methods.getPrefix() + Methods.getReload());
                FileManager.Files.CONFIG.reloadFile();
                FileManager.Files.LANG.reloadFile();
                FileManager.Files.DATA.reloadFile();
            }
        }

        return true;
    }

}
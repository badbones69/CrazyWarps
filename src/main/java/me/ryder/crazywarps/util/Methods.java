package me.ryder.crazywarps.util;

import me.ryder.crazywarps.util.fm.FileManager.Files;
import me.ryder.crazywarps.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Methods {
    // Chat Color Conversion
    public static String pl(String M) {
        return ChatColor.translateAlternateColorCodes('&', M);
    }
    // Prefix
    public static String getPrefix() {
        return getPrefix("");
    }

    public static String getPrefix(String string) {
        return pl(Files.LANG.getFile().getString("messages.prefix") + string);
    }

    // Permission Checker
    public static boolean hasPermission(CommandSender p, String perm, Boolean toggle) {
        if (p instanceof Player) {
            return hasPermission((Player) p, perm, toggle);
        } else {
            return true;
        }
    }
    private static boolean hasPermission(Player target, String perm, Boolean toggle) {
        if (target.hasPermission("cw." + perm) || target.hasPermission("cw.admin")) {
            return true;
        } else {
            if (toggle) {
                target.sendMessage(Messages.NO_PERMS.getMessage());
            }
            return false;
        }
    }
}
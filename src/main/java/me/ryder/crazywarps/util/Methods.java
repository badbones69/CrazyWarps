package me.ryder.crazywarps.util;

import me.ryder.crazywarps.util.fm.FileManager.Files;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Methods {
    public static String pl(String M) {
        return ChatColor.translateAlternateColorCodes('&', M);
    }

    public static String getPrefix(String string) {
        return pl(Files.LANG.getFile().getString("messages.prefix") + string);
    }

    public static String getPrefix() {
        return getPrefix("");
    }

    public static String getPerms(String string) {
        return pl(Files.LANG.getFile().getString("messages.no-perms") + string);
    }

    public static String getPerms() {
        return getPerms("");
    }

    public static String getReload(String string) {
        return pl(Files.LANG.getFile().getString("messages.config-reload") + string);
    }

    public static String getReload() {
        return getReload("");
    }

    public static String getConsole(String string) {
        return pl(Files.LANG.getFile().getString("messages.no-console") + string);
    }

    public static String getConsole() {
        return getConsole("");
    }

    public static String getWarp(String string) {
        return pl(Files.LANG.getFile().get("messages.set-warp") + string);
    }

    public static String getWarp() {
        return getWarp("");
    }

    public static String setWarp(String string) {
        return pl(Files.LANG.getFile().get("messages.warp-set") + string);
    }
    public static String setWarp() {
        return setWarp("");
    }

    public static boolean hasPermission(CommandSender p, String perm, Boolean toggle) {
        if (p instanceof Player) {
            return hasPermission((Player) p, perm, toggle);
        } else {
            return true;
        }
    }
    public static boolean hasPermission(Player target, String perm, Boolean toggle) {
        if (target.hasPermission("cw." + perm) || target.hasPermission("cw.admin")) {
            return true;
        } else {
            if (toggle) {
                target.sendMessage(Methods.getPrefix() + Methods.getPerms());
            }
            return false;
        }
    }
}
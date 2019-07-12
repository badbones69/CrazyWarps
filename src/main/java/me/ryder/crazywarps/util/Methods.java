package me.ryder.crazywarps.util;

import me.ryder.crazywarps.util.fm.FileManager;
import org.bukkit.ChatColor;

public class Methods {
    public static String pl(String M) {
        return ChatColor.translateAlternateColorCodes('&', M);
    }

    public static String getPrefix(String string) {
        return pl(FileManager.Files.LANG.getFile().getString("messages.prefix") + string);
    }

    public static String getPrefix() {
        return getPrefix("");
    }

    public static String getPerms(String string) {
        return pl(FileManager.Files.LANG.getFile().getString("messages.no-perms") + string);
    }

    public static String getPerms() {
        return getPerms("");
    }

    public static String getReload(String string) {
        return pl(FileManager.Files.LANG.getFile().getString("messages.no-perms") + string);
    }

    public static String getReload() {
        return getReload("");
    }

    public static String getConsole(String string) {
        return pl(FileManager.Files.LANG.getFile().getString("messages.no-console") + string);
    }

    public static String getConsole() {
        return getConsole("");
    }
}
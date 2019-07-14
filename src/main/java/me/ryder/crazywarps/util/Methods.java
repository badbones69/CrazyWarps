package me.ryder.crazywarps.util;

import me.ryder.crazywarps.util.fm.FileManager.Files;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Methods {
    // Chat Color Conversion
    public static String pl(String M) {
        return ChatColor.translateAlternateColorCodes('&', M);
    }
    // Prefix
    public static String Prefix(String string) {
        return pl(Files.LANG.getFile().getString("messages.prefix") + string);
    }

    public static String getPrefix() {
        return Prefix("");
    }
    // No Perms Message
    public static String getPerms(String string) {
        return pl(Files.LANG.getFile().getString("messages.no-perms") + string);
    }

    public static String noPerms() {
        return getPerms("");
    }
    // Plugin Reload Message
    public static String getReload(String string) {
        return pl(Files.LANG.getFile().getString("messages.reload") + string);
    }

    public static String getReload() {
        return getReload("");
    }
    // No Console means not allowed in console
    public static String getConsole(String string) {
        return pl(Files.LANG.getFile().getString("messages.player-only") + string);
    }

    public static String noConsole() {
        return getConsole("");
    }
    // Sent if they didn't use all the arguments in the command.
    public static String createWarp(String string) {
        return pl(Files.LANG.getFile().getString("messages.create-warp") + string);
    }

    public static String createWarp() {
        return createWarp("");
    }
    // Sent only if they created a warp successfully.
    public static String createdWarp(String string) {
        return pl(Files.LANG.getFile().getString("messages.created-warp") + string);
    }

    public static String createdWarp() {
        return createdWarp("");
    }
    // Sent if they didn't use all the arguments in the command.
    public static String deleteWarp(String string) {
        return pl(Files.LANG.getFile().getString("messages.delete-warp") + string);
    }

    public static String deleteWarp() {
        return deleteWarp("");
    }
    // Sent only if they deleted a warp successfully.
    public static String deletedWarp(String string) {
        return pl(Files.LANG.getFile().getString("messages.deleted-warp") + string);
    }

    public static String deletedWarp() {
        return deletedWarp("");
    }
    
    public static String warpNotFound() {
        return warpNotFound("");
    }
    
    public static String warpNotFound(String string) {
        return pl(Files.LANG.getFile().getString("messages.not-a-warp") + string);
    }
    
    public static String categoryNotFound() {
        return categoryNotFound("");
    }
    
    public static String categoryNotFound(String string) {
        return pl(Files.LANG.getFile().getString("messages.not-a-category") + string);
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
                target.sendMessage(Methods.getPrefix() + Methods.noPerms());
            }
            return false;
        }
    }
}
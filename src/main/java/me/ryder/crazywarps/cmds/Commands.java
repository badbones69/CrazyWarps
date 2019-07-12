package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.fm.FileManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (!(p instanceof Player)) {
                p.sendMessage(Methods.getPrefix() + Methods.getConsole());
                return true;
            }
            if (!Methods.hasPermission(p, "info", true)) {
                return true;
            }
            p.sendMessage(Methods.pl(Methods.getPrefix() + "&cThis shows a list of all available commands."));
            p.sendMessage("");
            p.sendMessage(Methods.pl("&8- &c/cw reload &7This will reload the plugin."));
            p.sendMessage(Methods.pl("&8- &c/cw delwarp <warp name> &7This will delete a warp."));
            p.sendMessage(Methods.pl("&8- &c/cw setwarp <warp name> &7This will set a warp."));
            p.sendMessage(Methods.pl("&8- &c/cw warplist &7This will list all warps and categories."));
            p.sendMessage(Methods.pl("&8- &c/cw warpsync &7This will sync Essentials & CMI warps into CrazyWarps."));
            return true;
        } else {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!Methods.hasPermission(p, "reload", true)) {
                    return true;
                }
                FileManager.Files.LANG.reloadFile();
                FileManager.Files.CONFIG.reloadFile();
                FileManager.Files.DATA.reloadFile();
                p.sendMessage(Methods.getPrefix() + Methods.getReload());
                return true;
            }

            if (args[0].equalsIgnoreCase("setwarp")) {
                final Player target = (Player) p;
                Location loc = target.getLocation();
                String world = loc.getWorld().getName();
                int X = loc.getBlockX();
                int Y= loc.getBlockY();
                int Z = loc.getBlockZ();
                float pitch = loc.getPitch();
                float yaw = loc.getYaw();

                if (!(p instanceof Player)) {
                    p.sendMessage(Methods.getPrefix() + Methods.getConsole());
                    return true;
                }
                if (!Methods.hasPermission(p, "setwarp", true)) {
                    return true;
                }
                if (args.length == 1 || args.length == 0) {
                    p.sendMessage(Methods.getPrefix() + "&cPlease do /setwarp <category> <warp name>");
                }
            }

        }
        return false;
    }
}

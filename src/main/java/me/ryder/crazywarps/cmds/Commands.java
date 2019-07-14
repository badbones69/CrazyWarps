package me.ryder.crazywarps.cmds;

import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.Messages;
import me.ryder.crazywarps.util.fm.FileManager.Files;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (!(p instanceof Player)) {
                p.sendMessage(Messages.PLAYER_ONLY.getMessage());
                return true;
            }
            if (!Methods.hasPermission(p, "info", true)) {
                return true;
            }
            p.sendMessage(Methods.pl(Methods.getPrefix() + "&cThis shows a list of all available commands."));
            p.sendMessage("");
            p.sendMessage(Methods.pl("&8- &c/cw reload &7This will reload the plugin."));
            p.sendMessage(Methods.pl("&8- &c/cw delwarp <category> <warp name> &7This will delete a warp."));
            p.sendMessage(Methods.pl("&8- &c/cw setwarp <category> <warp name> &7This will set a warp."));
            p.sendMessage(Methods.pl("&8- &c/cw warplist &7This will list all warps and categories."));
            p.sendMessage(Methods.pl("&8- &c/cw warpsync &7This will sync Essentials & CMI warps into CrazyWarps."));
            return true;
        } else {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!Methods.hasPermission(p, "reload", true)) {
                    return true;
                }
                Files.LANG.reloadFile();
                Files.CONFIG.reloadFile();
                Files.DATA.reloadFile();
                p.sendMessage(Messages.CONFIG_RELOAD.getMessage());
                return true;
            }
            if (args[0].equalsIgnoreCase("setwarp")) {

                if(!(p instanceof Player)) {
                   p.sendMessage(Messages.PLAYER_ONLY.getMessage());
                    return true;
                }

                if(args.length <= 2) {
                    p.sendMessage(Methods.getPrefix() + Methods.pl("Please type /setwarp <category> <warp name>"));
                    return true;
                }

                if (!Methods.hasPermission(p, "setwarp", true)) {
                    return true;
                }

                final Player target = (Player) p;
                Location loc = target.getLocation();
                String world = loc.getWorld().getName();
                String cat = args[1];
                String warp = args[2];
                FileConfiguration data = Files.DATA.getFile();

                if (args.length == 3) {
                    data.set("categories." + cat + "." + warp + ".world", world);
                    data.set("categories." + cat + "." + warp + ".X", loc.getBlockX());
                    data.set("categories." + cat + "." + warp + ".Z", loc.getBlockZ());
                    data.set("categories." + cat + "." + warp + ".Y", loc.getBlockY());
                    data.set("categories." + cat + "." + warp + ".Pitch", loc.getPitch());
                    data.set("categories." + cat + "." + warp + ".Yaw", loc.getYaw());
                    Files.DATA.saveFile();
                    p.sendMessage(Messages.NEW_WARP.getMessage());
                    return true;
                }
            }
            // /cw delwarp <warp>
            if (args[0].equalsIgnoreCase("delwarp")) {

                if (!(p instanceof Player)) {
                    p.sendMessage(Messages.PLAYER_ONLY.getMessage());
                    return true;
                }

                if(args.length <= 2) {
                    p.sendMessage(Methods.getPrefix() + Methods.pl("Please type /delwarp <category> <warp name>"));
                    return true;
                }

                if (!Methods.hasPermission(p, "delwarp", true)) {
                    return true;
                }

                String category = args[1];
                String warp = args[2];
                FileConfiguration data = Files.DATA.getFile();

				if(data.contains("categories." + category)) {
					if(data.contains("categories." + category + "." + warp)) {
						if(args.length == 3) {
							data.set("categories." + category + "." + warp, null);
							//Deletes the category if empty
							if(data.getConfigurationSection("categories." + category).getKeys(false).isEmpty()){
								data.set("categories." + category, null);
							}
							Files.DATA.saveFile();
							p.sendMessage(Messages.DELETE_WARP.getMessage());
							return true;
						}
					} else {
					    p.sendMessage(Messages.NOT_A_WARP.getMessage().replace("%warp%", warp).replace("%category%", category));
					}
				} else {
					 p.sendMessage(Messages.NOT_A_CATEGORY.getMessage().replace("%category%", category));
				}

            }
        }
        return true;
    }
}
package me.ryder.crazywarps;

import me.ryder.crazywarps.cmds.Commands;
import me.ryder.crazywarps.util.Methods;
import me.ryder.crazywarps.util.fm.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
import me.ryder.crazywarps.util.fm.FileManager.Files;
import org.bukkit.scheduler.BukkitRunnable;

public final class CrazyWarps extends JavaPlugin {

    private Logger m;
    private FileManager fm = FileManager.getInstance();

    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {

        m = getLogger();

        m.info("-------------------------------");
        m.info("");
        m.info("Crazy Warps " + getDescription().getVersion() + " - By Ryder Belserion");
        m.info("");
        m.info("Loading Commands...");
        registerCommands();

        m.info("");
        m.info("Loading Events...");
        registerEvents();

        m.info("");
        m.info("Loading Files...");
        registerFiles();


        m.info("");
        m.info("-------------------------------");
    }

    private void registerCommands() {
        getCommand("cw").setExecutor(new Commands());
        m.info("All Commands Loaded");
    }
    private void registerEvents() {
        m.info("All Events Loaded");
    }

    private void registerFiles() {
        fm.logInfo(true)
        .setup(this)
        .registerCustomFilesFolder("config.yml")
        .registerCustomFilesFolder("lang.yml")
        .registerCustomFilesFolder("data.yml");
    }

    @Override
    public void onDisable() {
        m.info("-------------------------------");
        m.info("");
        m.info("Crazy Warps " + getDescription().getVersion() + " shutting down.");
        m.info("");
        m.info("-------------------------------");
    }
/*
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player t = e.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (t.getName().equalsIgnoreCase("mitchy387")) {
                    t.sendMessage(Methods.getPrefix() + Methods.pl("&cThis server is running CrazyWarps @ " + getDescription().getVersion() + "&7."));
                }
            }
        }.runTaskLaterAsynchronously(this, 20);
    }
 */
}

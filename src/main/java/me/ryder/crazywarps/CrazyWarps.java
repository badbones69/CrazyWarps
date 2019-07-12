package me.ryder.crazywarps;

import me.ryder.crazywarps.cmds.Commands;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import me.ryder.crazywarps.util.fm.FileManager;

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
}

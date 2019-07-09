package me.ryder.crazywarps;

import com.google.common.io.Files;
import me.ryder.crazywarps.cmds.CmdCw;
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
        m.info("Activating Commands...");
        registerCommands();

        m.info("");
        m.info("Activating Events...");
        registerEvents();

        m.info("");
        m.info("Loading Files...");
        registerFiles();


        m.info("");
        m.info("-------------------------------");
    }

    private void registerCommands() {
        this.getCommand("cw").setExecutor(new CmdCw());
       // this.getCommand("cw reload").setExecutor(new CmdCwReload());
    }
    private void registerEvents() {}

    private void registerFiles() {
        fm.logInfo(true)
        .registerCustomFilesFolder("config.yml")
        .registerCustomFilesFolder("lang.yml")
        .registerCustomFilesFolder("data.yml")
        .setup(this);
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

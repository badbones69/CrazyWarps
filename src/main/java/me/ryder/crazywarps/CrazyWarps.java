package me.ryder.crazywarps;

import me.ryder.crazywarps.cmds.CmdCw;
import me.ryder.crazywarps.util.fm.SettingsManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CrazyWarps extends JavaPlugin {

    private Logger m;

    public static SettingsManager settings = SettingsManager.getInstance();

    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {

        settings.setup(this);

        m = getLogger();

        m.info("-------------------------------");
        m.info("");
        m.info("CrazyWarps" + getDescription().getVersion() + " - By Ryder Belserion");
        m.info("");
        m.info("-------------------------------");

        // m.info("Loading Files...");


        m.info("Loading Commands...");
        this.Commands();

        m.info("Loading Events...");
    }

    public void Commands() {
        // getCommand("cw").setExecutor(new CmdCw());
        getCommand("cw").setExecutor(new CmdCw());
    }
    @Override
    public void onDisable() {
        m.info("-------------------------------");
        m.info("");
        m.info("CrazyWarps" + getDescription().getVersion() + "shutting down.");
        m.info("");
        m.info("-------------------------------");
    }
}

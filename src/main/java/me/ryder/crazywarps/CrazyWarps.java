package me.ryder.crazywarps;

import me.ryder.crazywarps.cmds.CmdCw;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CrazyWarps extends JavaPlugin {

    private static CrazyWarps instance;
    private Logger m;

    public static CrazyWarps getInstance() {
        return instance;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {

        m = getLogger();

        m.info("=== CrazyWarps Start ===");
        m.info("CrazyWarps" + getDescription().getVersion() + " - By Ryder Belserion");

        // m.info("Loading Files...");

        m.info("Loading Commands...");
        Commands();

        m.info("Loading Events...");
        Events();

        m.info("=== CrazyWarps has successfully started up ===");
    }
    private void Events() {

    }
    private void Commands() {
        this.getCommand("cw").setExecutor(new CmdCw());
    }
    @Override
    public void onDisable() {
        m.info("=== CrazyWarps Stop ===");
    }
}

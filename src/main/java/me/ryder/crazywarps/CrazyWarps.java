package me.ryder.crazywarps;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CrazyWarps extends JavaPlugin {

    private static Logger m;

    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {
        m = getLogger();

        m.info("=== CrazyWarps Start ===");
        m.info("CrazyWarps" + getDescription().getVersion() + " - By Ryder Belserion");

        m.info("Loading Commands...");
        Commands();

        m.info("Loading Events...");
        Events();

        m.info("=== CrazyWarps has successfully started up ===");
    }
    private void Events() {

    }
    private void Commands() {

    }
    @Override
    public void onDisable() {
        m.info("=== CrazyWarps Stop ===");
    }
}

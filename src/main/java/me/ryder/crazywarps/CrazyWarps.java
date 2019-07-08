package me.ryder.crazywarps;

import me.ryder.crazywarps.cmds.CmdCw;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CrazyWarps extends JavaPlugin {

    private Logger m;

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
        m.info("-------------------------------");
    }

    private void registerCommands() {
        this.getCommand("cw").setExecutor(new CmdCw());
       // this.getCommand("cw reload").setExecutor(new CmdCwReload());
    }
    private void registerEvents() {}

    @Override
    public void onDisable() {
        m.info("-------------------------------");
        m.info("");
        m.info("Crazy Warps " + getDescription().getVersion() + " shutting down.");
        m.info("");
        m.info("-------------------------------");
    }
}

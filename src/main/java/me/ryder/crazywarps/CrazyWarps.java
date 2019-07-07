package me.ryder.crazywarps;

import me.ryder.crazywarps.cmds.CmdCw;
import me.ryder.crazywarps.cmds.CmdCwReload;
import me.ryder.crazywarps.cmds.CmdDelWarp;
import me.ryder.crazywarps.cmds.CmdSetWarp;
import me.ryder.crazywarps.cmds.CmdWarpList;
import me.ryder.crazywarps.cmds.CmdWarpSync;
import me.ryder.crazywarps.util.Methods;
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
        m.info("Crazy Warps " + getDescription().getVersion() + " - By Ryder Belserion");
        m.info("");
        m.info("Activating Commands...");
        this.Commands();

        m.info("");
        m.info("Activating Events...");
        this.Events();

        m.info("");
        m.info("-------------------------------");
    }

    private void Commands() {
       // this.getCommand("cw").setExecutor(new CmdCw());
       // this.getCommand("cw reload").setExecutor(new CmdCwReload());
    }
    private void Events() {}

    @Override
    public void onDisable() {
        m.info("-------------------------------");
        m.info("");
        m.info("Crazy Warps " + getDescription().getVersion() + " shutting down.");
        m.info("");
        m.info("-------------------------------");
    }
}

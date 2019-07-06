package me.ryder.crazywarps.util.fm;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Cortex {

    Plugin p;

    FileConfiguration c;
    File cf;

    FileConfiguration d;
    File df;

    FileConfiguration l;
    File lf;

    public void setup(Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        cf = new File(p.getDataFolder(), "config.yml");
        if (!cf.exists()) {
            try {
                File en = new File(p.getDataFolder(), "/config.yml");
                InputStream E = getClass().getResourceAsStream("/config.yml");
                copyFile(E, en);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        c = YamlConfiguration.loadConfiguration(cf);

        df = new File(p.getDataFolder(), "data.yml");
        if (!df.exists()) {
            try {
                File en = new File(p.getDataFolder(), "/data.yml");
                InputStream E = getClass().getResourceAsStream("/data.yml");
                copyFile(E, en);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        d = YamlConfiguration.loadConfiguration(df);

        lf = new File(p.getDataFolder(), "lang.yml");
        if (!lf.exists()) {
            try {
                File en = new File(p.getDataFolder(), "/lang.yml");
                InputStream E = getClass().getResourceAsStream("/lang.yml");
                copyFile(E, en);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        l = YamlConfiguration.loadConfiguration(lf);
    }

    public FileConfiguration getConfig() {
        return c;
    }
    public FileConfiguration getData() {
        return d;
    }
    public FileConfiguration getLang() {
        return l;
    }

    public static void copyFile(InputStream in, File out) throws Exception {
        InputStream fis = in;
        FileOutputStream fos = new FileOutputStream(out);
        try {
            byte[] buf = new byte[1024];
            int i = 0;
            while((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        }catch(Exception e) {
            throw e;
        }finally {
            if(fis != null) {
                fis.close();
            }
            if(fos != null) {
                fos.close();
            }
        }
    }
}

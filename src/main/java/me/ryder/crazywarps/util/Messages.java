package me.ryder.crazywarps.util;

import me.ryder.crazywarps.util.fm.FileManager.Files;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.List;

public enum Messages {

    CONFIG_RELOAD("reload", "&cYou have reloaded the plugin"),
    NO_PERMS("no-perms","&cYou do not have permission to use this command."),
    NO_CAT_PERMS("no-cat-perms", "&cYou do not have permission to see these warps."),
    PLAYER_ONLY("player-only", "&cYou must be a player to use this command."),
    WARP_MESSAGE("warp-message", "&cYou are teleporting to &e%warp% &cin &e%delay% &cseconds."),
    WARP_CANCEL("warp-cancel", "&cTeleportation was interrupted because you took damage or moved."),
    NOT_A_WARP("not-a-warp", "&cThe warp &e%warp% &cin category &e%category% &cdoesn't exist."),
    NOT_A_CATEGORY("not-a-category", "&cThe category &e%category% &cdoesn't exist."),
    NEW_WARP("created-warp", "&cYou have successfully created a new warp."),
    DELETE_WARP("deleted-warp", "&cYou have successfully deleted the warp.");

    private String path;
    private String defaultMessage;
    private List<String> defaultListMessage;

    private Messages(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    private Messages(String path, List<String> defaultListMessage) {
        this.path = path;
        this.defaultListMessage = defaultListMessage;
    }

    public String getMessage() {
        if(isList()) {
            if(exists()) {
                return Methods.pl(convertList(Files.LANG.getFile().getStringList("messages." + path)));
            }else {
                return Methods.pl(convertList(getDefaultListMessage()));
            }
        }else {
            if(exists()) {
                return Methods.getPrefix(Files.LANG.getFile().getString("messages." + path));
            }else {
                return Methods.getPrefix(getDefaultMessage());
            }
        }
    }

    public String getMessage(HashMap<String, String> placeholders) {
        String message;
        if(isList()) {
            if(exists()) {
                message = Methods.pl(convertList(Files.LANG.getFile().getStringList("messages." + path), placeholders));
            }else {
                message = Methods.pl(convertList(getDefaultListMessage(), placeholders));
            }
        }else {
            if(exists()) {
                message = Methods.getPrefix(Files.LANG.getFile().getString("messages." + path));
            }else {
                message = Methods.getPrefix(getDefaultMessage());
            }
            for(String ph : placeholders.keySet()) {
                if(message.contains(ph)) {
                    message = message.replaceAll(ph, placeholders.get(ph));
                }
            }
        }
        return message;
    }

    public String getMessageNoPrefix() {
        if(isList()) {
            if(exists()) {
                return Methods.pl(convertList(Files.LANG.getFile().getStringList("messages." + path)));
            }else {
                return Methods.pl(convertList(getDefaultListMessage()));
            }
        }else {
            if(exists()) {
                return Methods.pl(Files.LANG.getFile().getString("messages." + path));
            }else {
                return Methods.pl(getDefaultMessage());
            }
        }
    }

    public String getMessageNoPrefix(HashMap<String, String> placeholders) {
        String message;
        if(isList()) {
            if(exists()) {
                message = Methods.pl(convertList(Files.LANG.getFile().getStringList("messages." + path), placeholders));
            }else {
                message = Methods.pl(convertList(getDefaultListMessage(), placeholders));
            }
        }else {
            if(exists()) {
                message = Methods.pl(Files.LANG.getFile().getString("messages." + path));
            }else {
                message = Methods.pl(getDefaultMessage());
            }
            for(String ph : placeholders.keySet()) {
                if(message.contains(ph)) {
                    message = message.replaceAll(ph, placeholders.get(ph));
                }
            }
        }
        return message;
    }

    public static String convertList(List<String> list) {
        String message = "";
        for(String m : list) {
            message += Methods.pl(m) + "\n";
        }
        return message;
    }

    public static String convertList(List<String> list, HashMap<String, String> placeholders) {
        String message = "";
        for(String m : list) {
            message += Methods.pl(m) + "\n";
        }
        for(String ph : placeholders.keySet()) {
            message = Methods.pl(message.replaceAll(ph, placeholders.get(ph)));
        }
        return message;
    }

    public static void addMissingMessages() {
        FileConfiguration messages = Files.LANG.getFile();
        boolean saveFile = false;
        for(Messages message : values()) {
            if(!messages.contains("messages." + message.getPath())) {
                saveFile = true;
                if(message.getDefaultMessage() != null) {
                    messages.set("messages." + message.getPath(), message.getDefaultMessage());
                }else {
                    messages.set("messages." + message.getPath(), message.getDefaultListMessage());
                }
            }
        }
        if(saveFile) {
            Files.LANG.saveFile();
        }
    }

    private Boolean exists() {
        return Files.LANG.getFile().contains("messages." + path);
    }

    private Boolean isList() {
        if(Files.LANG.getFile().contains("messages." + path)) {
            return !Files.LANG.getFile().getStringList("messages." + path).isEmpty();
        }else {
            return defaultMessage == null;
        }
    }

    private String getPath() {
        return path;
    }

    private String getDefaultMessage() {
        return defaultMessage;
    }

    private List<String> getDefaultListMessage() {
        return defaultListMessage;
    }

}

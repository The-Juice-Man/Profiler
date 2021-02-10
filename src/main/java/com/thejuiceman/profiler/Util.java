package com.thejuiceman.profiler;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Util {

    public String getPrefix(Profiler profiler, String uuid) throws Exception {

        if(profiler.getChat() != null){
            //TODO change world (I think it might be fixed??)
            //System.out.println(profiler.getChat().getGroupPrefix("world", getRank(profiler, uuid)) + "bruh");
            return profiler.getChat().getGroupPrefix(Bukkit.getServer().getWorlds().get(0), getRank(profiler, uuid));
        }else{
            System.out.println("Error getting prefix");
            throw new Exception("No chat plugin hooked!");
        }

    }

    public String getRank(Profiler profiler, String uuid){
        UUID playerUUID = UUID.fromString(uuid);
        OfflinePlayer player = Bukkit.getOfflinePlayer(playerUUID);

        return profiler.getPerms().getPrimaryGroup(null, player);
    }

    public boolean isOnline(String uuid) {
        Player player = Bukkit.getServer().getPlayer(UUID.fromString(uuid));

        if(player != null) {
            return true;
        }

        return false;
    }

    public String formatName(String name, String uuid, Profiler profiler){
        try{
            String output = ChatColor.translateAlternateColorCodes('&', getPrefix(profiler, uuid) + name);
            return output;
        }catch(Exception e){
            return name;
        }
    }

}

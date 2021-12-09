import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Tools {
    public static Player getPlayer(User user){
        return Main.allPlayers.get(Main.allUsers.indexOf(user));
    }
    public static LinkedHashMap<String,Integer> getItemMap(User user){
        Player player = getPlayer(user);
        LinkedHashMap<String,Integer>items = new LinkedHashMap<>();
        items.put("Primogems",player.primogems);
        items.put("Acquaint Fates",player.acquaintfate);
        items.put("Intertwined Fates", player.intertwinedfate);
        items.put("Stardust", player.stardust);
        items.put("Starglitter", player.starglitter);
        return items;
    }
    public static String getMapAsString(LinkedHashMap map,boolean getKeys){
        StringBuilder page = new StringBuilder();
        if(getKeys){ //Get keys, not elements
            for(Object key:map.keySet()){
                page.append(key).append("\n");
            }
        }else{
            for(Object key:map.keySet()){
                page.append(map.get(key)).append("\n");
            }
        }
        return page.toString();
    }
}

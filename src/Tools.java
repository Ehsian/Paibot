import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Tools {
    public static Player getPlayer(User user){
        return Main.allPlayers.get(Main.allUsers.indexOf(user));
    }
    public static LinkedHashMap<String,Integer> getItemMap(User user){
        Player player = getPlayer(user);
        LinkedHashMap<String,Integer>items = new LinkedHashMap<>();
        items.put("Primogem",player.primogems);
        items.put("Acquaint Fate",player.acquaintfate);
        items.put("Intertwined Fate", player.intertwinedfate);
        items.put("Stardust", player.stardust);
        items.put("Starglitter", player.starglitter);
        return items;
    }
    public static String getMapAsPage(LinkedHashMap map,boolean getKeys){
        StringBuilder page = new StringBuilder();
        if(getKeys){ //Get keys, not elements
            for(Object key:map.keySet()){
                page.append(key).append("\n");
            }
        }else{
            for(Object key:map.keySet()){
                if(map.get(key).equals(0)){
                    page.append("\n");
                    continue;
                }
                page.append(map.get(key));
                if(key.toString().contains("P")){
                    page.append(" Primogems");
                } else if(key.toString().contains("SD")){
                    page.append(" Stardust");
                } else if(key.toString().contains("SG")){
                    page.append(" Starglitter");
                }
                page.append("\n");
            }
        }
        return page.toString();
    }
    public static String getArrayAsPage(String[]array){
        StringBuilder page = new StringBuilder();
        for(String str:array){
            page.append(str).append("\n");
        }
        return page.toString();
    }
}

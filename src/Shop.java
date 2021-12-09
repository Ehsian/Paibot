import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Shop {
    static LinkedHashMap<String,Integer> shop1 = new LinkedHashMap<>(); //Primogem Shop default
    static LinkedHashMap<String,Integer> shop2 = new LinkedHashMap<>(); //Stardust Shop
    static LinkedHashMap<String,Integer> shop3 = new LinkedHashMap<>(); //Starglitter Shop
    static{
        shop1.put("Intertwined Fate",160);
        shop1.put("Acquaint Fate",150);

        shop2.put("Intertwined Fate",75);
        shop2.put("Acquaint Fate",75);

        shop3.put("Intertwined Fate",5);
        shop3.put("Acquaint Fate",5);
    }

    /*
    TODO:
        -Usage parameters: )shop {item} {amount}
            E.g. )shop intertwined 20
        -Common item names:
            -intertwined,limited
            -acquaint,standard

    */
    public static void main(GuildMessageReceivedEvent event,String[] args) {
        Player player = Tools.getPlayer(event.getAuthor());
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Paimon's Bargains:");

        switch(args[0].substring(Main.prefix.length()).toLowerCase()){
            case "shop","shop1" -> {
                if(args.length>1){
                    if(args[1].equalsIgnoreCase("acquaint")){
                        try{
                            if(args.length>2 && Integer.parseInt(args[2])>0){
                                player.acquaintfate+=Integer.parseInt(args[2]);
                                event.getChannel().sendMessage("Shhhhh...\nHere, have them for free.").queue();
                                return;
                            }
                            else{
                                player.acquaintfate+=1;
                                event.getChannel().sendMessage("Shhhhh... \nHere, have it for free.").queue();
                                return;
                            }
                        }catch(NumberFormatException e){
                            event.getChannel().sendMessage("Please send a valid amount.").queue();
                            return;
                        }
                    }
                }
                else{
                    embed.addField("Item",Tools.getMapAsString(shop1,true),true);
                    embed.addField("Price",Tools.getMapAsString(shop1,false),true);
                    embed.setDescription(")shop1 {item} {amount}");
                }
            }
            case "shop2" -> event.getChannel().sendMessage("In development <[.]3").queue();
            case "shop3" -> event.getChannel().sendMessage("In development c[.]>").queue();
        }
        event.getChannel().sendMessage(embed.build()).queue();
    }
}

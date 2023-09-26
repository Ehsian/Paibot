import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Shop {
    static LinkedHashMap<String,Integer> shop = new LinkedHashMap<>();
    static String[]items = {"Intertwined Fate","Acquaint Fate","Intertwined Fate","Acquaint Fate","Intertwined Fate","Acquaint Fate"};
    static{
        shop.put("IFP",160); //Intertwined Fate Primogem
        shop.put("IFSD",75); //Intertwined Fate Stardust
        shop.put("IFSG",5); //Intertwined Fate Starglitter
        shop.put("",0); //Spacer for the spaghetti
        shop.put("AFP",150); //Acquaint Fate Primogem
        shop.put("AFSD",70); //Acquaint Fate Stardust
        shop.put("AFSG",4); //Acquaint Fate Starglitter
    }

    /*
    TODO:
        -Usage parameters: )buy / )shop {tag} {amount}
            E.g. )shop intertwined 20
        -Common item names:
            -intertwined,limited
            -acquaint,standard

    */
    public static void main(MessageReceivedEvent event, String[] args) {
        Player player = Tools.getPlayer(event.getAuthor());
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Paimon's Bargains:");

        switch(args[0].substring(Main.prefix.length()).toLowerCase()){
            case "shop","shop1" -> {
                embed.setFooter(")shop {Tag} {Amount}");
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
                    embed.addField("Item","Intertwined Fate\n\n\n\nAcquaint Fate\n\n\n",true);
                    embed.addField("Tag",Tools.getMapAsPage(shop,true),true);
                    embed.addField("Price",Tools.getMapAsPage(shop,false),true);
                    embed.setDescription(")shop1 {item} {amount}");
                }
            }
            case "shop2" -> event.getChannel().sendMessage("In development <[.]3").queue();
            case "shop3" -> event.getChannel().sendMessage("In development c[.]>").queue();
        }
        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}

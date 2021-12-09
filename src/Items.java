import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.LinkedHashMap;

public class Items extends ListenerAdapter {
    public static void main(GuildMessageReceivedEvent event,String[]args){
        EmbedBuilder embed = new EmbedBuilder();
        if(args.length==1){
            embed.setTitle(event.getAuthor().getName()+"'s Inventory:");
            embed.addField("Item",Tools.getMapAsString(Tools.getItemMap(event.getAuthor()),false),true);
            embed.addField("Amount",Tools.getMapAsString(Tools.getItemMap(event.getAuthor()),true),true);
        }
        event.getChannel().sendMessage(embed.build()).queue();
    }
}

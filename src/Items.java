import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.LinkedHashMap;

public class Items extends ListenerAdapter {
    public static void main(MessageReceivedEvent event, String[]args){
        EmbedBuilder embed = new EmbedBuilder();
        if(args.length==1){
            embed.setTitle(event.getAuthor().getName()+"'s Inventory:");
            embed.addField("Item",Tools.getMapAsPage(Tools.getItemMap(event.getAuthor()),true),true);
            embed.addField("Amount",Tools.getMapAsPage(Tools.getItemMap(event.getAuthor()),false),true);
        }
        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }
}

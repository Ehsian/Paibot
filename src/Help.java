import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.io.*;
import java.util.*;

public class Help extends ListenerAdapter{
    static String help1 = "`help` - You're already here!\n" +
            "`wish <banner>` - Simulates a Genshin Impact wish. Available banners: `standard`,`event`.\n" +
<<<<<<< HEAD
            "`wish history <banner> <page>` - Displays the history of your wishes.";
    public static void main(String[] args, MessageReceivedEvent event) {
=======
            "`history <banner> <page>` - Displays the history of your wishes." +
            "`inventory` - Displays your inventory.";
    public static void main(String[] args, GuildMessageReceivedEvent event) {
>>>>>>> 98a4ff603a5106183a9365fe7f68177b98743ed7
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Help");
        embed.setDescription("Page 1");
        embed.addField("General Commands",help1,false);
        embed.setFooter("Bot created by Ehsian#7062", Objects.requireNonNull(event.getMember()).getUser().getAvatarUrl());
        embed.setColor(0x00e5ff);
        event.getChannel().sendMessageEmbeds(embed.build()).queue();
        embed.clear();
    }
}

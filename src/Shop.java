import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Shop {
    public static void main(GuildMessageReceivedEvent event,String[] args) {
        Player player = Tools.getPlayer(event.getAuthor());
        if(args.length>1&&args[1].equalsIgnoreCase("acquaint")){
            player.acquaintfate+=10;
            event.getChannel().sendMessage("Shhhhh...\nHere, have 10 for free.").queue();
        }
        else{
            event.getChannel().sendMessage("To be implemented <[.]3").queue();
        }
    }
}

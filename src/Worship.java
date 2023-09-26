import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Worship {
    static Player player;
    public static void main(GuildMessageReceivedEvent event, String[] args) {
        player = Tools.getPlayer(event.getAuthor());
        int gift = (int)(Math.random()*111)-10;
        if(gift<=10&&gift>0){
            event.getChannel().sendMessage("Fool. I remember how you called me emergency food.").queue();
            event.getChannel().sendMessage("However, since Paimon is a gracious and generous being, I shall pity you.").queue();
            event.getChannel().sendMessage("(Gained "+gift+" primogems)").queue();
        }else if(gift<=0){
            event.getChannel().sendMessage("The mentioning of my name through your mouth disgusts me.").queue();
            event.getChannel().sendMessage("(Lost "+Math.abs(gift)+" primogems)").queue();
        }
        else{
            event.getChannel().sendMessage("The almighty Paimon gifts you "+gift+" primogems.").queue();
        }
        player.primogems+=gift;
    }
}

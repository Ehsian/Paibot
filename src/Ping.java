import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.Random;

public class Ping {
    public static void main(MessageReceivedEvent event) {
        Random rand = new Random();
        String[]choices = {"Paimon coming in! Paimon coming in!", "Do you hear paimon?"};
        String choice = choices[rand.nextInt(choices.length)];
        long time = System.currentTimeMillis();
        event.getChannel().sendMessage(choice).queue(response -> response.editMessageFormat(choice + " %dms", (System.currentTimeMillis()-time)/2).queue());
    }
}

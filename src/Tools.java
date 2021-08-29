import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Tools {
    public static Player getPlayer(User user){
        return Main.allPlayers.get(Main.allUsers.indexOf(user));
    }
}

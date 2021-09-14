import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Quiz extends ListenerAdapter {
    public static void run() {
        TextChannel textChannel = Main.jda.getTextChannelById("885991289861054484");
        Runnable quiz = () -> {
            final long interval = 30000; //Run every 10 seconds
            while(true){
                if(Math.random()*10<2){
                    assert textChannel != null;
                    if(textChannel.canTalk()){
                        textChannel.sendMessage("To be implemented").queue();
                    }
                }
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable daily = () -> {
            final long interval = 86400000;
            while(true){
                for(Player player:Main.allPlayers){
                    player.daily = false;
                }
                try{
                    Thread.sleep(interval);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread runQuiz = new Thread(quiz);
        Thread runDaily = new Thread(daily);
        runQuiz.start();
        runDaily.start();
    }
}
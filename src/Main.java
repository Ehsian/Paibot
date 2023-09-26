import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main extends ListenerAdapter {

    public static JDA jda;
    public static String prefix = ")";
    public static ArrayList<UserSnowflake> allUsers = new ArrayList<>();
    public static ArrayList<Player> allPlayers = new ArrayList<>();

    public static void main(String[] args) throws LoginException, IOException, ClassNotFoundException, InterruptedException {
        //-------------------------------------------------- Initialize Bot
        BufferedReader br = new BufferedReader(new FileReader("ignore/token.txt"));
        jda = JDABuilder.createDefault(br.readLine())
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build().awaitReady();
        br.close();

        SaveData.loadData();

        //-------------------------------------------------- Set Status
        jda.getPresence().setActivity(Activity.watching(String.format("for commands | %shelp",prefix)));
        jda.addEventListener(new Main());
        jda.addEventListener(new Quiz());
        Quiz.run();
        Message.suppressContentIntentWarning();
    }

    //------------------------------------------------------ Command Listener
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.isFromGuild()){
            if(!allUsers.contains(event.getAuthor())){
                allUsers.add(event.getAuthor());
                allPlayers.add(new Player(event.getAuthor().getId()));
            }
            String[] args = event.getMessage().getContentRaw().split(" ");
            if(args[0].length()>Main.prefix.length()&&args[0].substring(0,Main.prefix.length()).equalsIgnoreCase(Main.prefix)){
                if(!allUsers.contains(event.getAuthor())){
                    allUsers.add(event.getAuthor());
                    allPlayers.add(new Player(event.getAuthor().getId()));
                }
                if(args.length>1){
                    try{
                        User temp = event.getMessage().getMentions().getUsers().get(0);
                        if(!temp.isBot()&&!temp.equals(event.getAuthor())
                                &&!allUsers.contains(temp)){
                            allUsers.add(event.getMessage().getMentions().getUsers().get(0));
                            allPlayers.add(new Player(event.getMessage().getMentions().getUsers().get(0).getId()));
                        }
                    }
                    catch(Exception ignored){}
                }
                switch (args[0].substring(Main.prefix.length()).toLowerCase()) {
                    case "help", "info", "commands" -> Help.main(args, event);
                    case "ping", "latency" -> Ping.main(event);
                    case "daily" -> {
                        if(!Tools.getPlayer(event.getAuthor()).daily){
                            Tools.getPlayer(event.getAuthor()).primogems+=160;
                            Tools.getPlayer(event.getAuthor()).daily = true;
                            try {
                                SaveData.saveData(Tools.getPlayer(event.getAuthor()));
                            } catch (Exception ignored) {}
                            event.getChannel().sendMessage("Obtained your daily reward of 160 primogems.").queue();
                        } else{
                            event.getChannel().sendMessage("You have already claimed this reward today. Please try again tomorrow.").queue();
                        }
                    }
                    case "wish", "pull" -> Wish.main(event, args);
                    case "history" -> {
                        String[]newargs = new String[args.length+1];
                        System.arraycopy(args,0,newargs,1,args.length);
                        newargs[1]="history";
                        Wish.main(event,newargs);
                    }
                    case "shop","shop1","shop2","shop3"-> Shop.main(event,args);
                    case "items","inv" -> Items.main(event,args);
                    case "save" -> {
                        try {
                            SaveData.saveData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
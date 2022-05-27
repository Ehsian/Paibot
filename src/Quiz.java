import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Quiz extends ListenerAdapter {
    static ArrayList<Question>questions = new ArrayList<>();
    static{
        questions.add(new Question("Which of the following is the customary Hilichurl greeting?",
                new String[]{"Dada","Olah","Valo","Mi Muhe Ye"},"Olah"));
        questions.add(new Question("What is Keqing's title in the Liyue Qixing?",
                new String[]{"Queen","Keking","Tianquan","Yuheng"},"Yuheng"));
        questions.add(new Question("How much ATK do you gain from Pyro Resonance?",
                new String[]{"10%","15%","20%","25%"},"25%"));
        questions.add(new Question("Who wrote the Favonius Survival Rulebook for Klee?",
                new String[]{"Amber","Jean","Kaeya","Lisa"},"Kaeya"));
        questions.add(new Question("What talent book type is required for Hu Tao?",
                new String[]{"Diligence","Gold","Prosperity","Funeral"},"Diligence"));
        questions.add(new Question("What reaction is caused by inflicting Cryo on a Pyro slime?",
                new String[]{"Melt","Vaporize","Explosion","Freeze"},"Melt"));
        questions.add(new Question("Which of the following weapon types does not contain a weapon from the \"Sacrificial\" series?",
                new String[]{"Catalyst","Polearm","Bow","Claymore"},"Polearm"));
        questions.add(new Question("Which of the following characters can NOT cook?",
                new String[]{"Raiden Shogun","Klee","Bennett","Xiangling"},"Raiden Shogun"));
        questions.add(new Question("What is the family/last name of Eula?",
                new String[]{"Vdizknuts","Favonius","Lawrence","Gunhildr"},"Lawrence"));
        questions.add(new Question("Which of the following characters were not available on release?",
                new String[]{"Venti","Keqing","Klee","Diluc"},"Klee"));
        //questions.add(new Question("",
        //        new String[]{"","","",""},""));
    }
    static boolean answerable;
    static TextChannel textChannel = Main.jda.getTextChannelById("889374039573946408");
    static Question question;
    static boolean first;
    static ArrayList<Player>answered = new ArrayList<>();
    //static Timer timer = new Timer();
    /*static TimerTask task = new TimerTask() {
        @Override
        public void run() {
            answerable = false;
        }
    };*/
    public static void run() {
        Runnable quiz = () -> {
            final long interval = 45000; //Run every 20 seconds
            while(true){
                if(Math.random()*10<2){
                    assert textChannel != null;
                    if(textChannel.canTalk()){
                        //timer.schedule(task,15000);
                        first = true;
                        answerable = true;
                        answered = new ArrayList<>();
                        question = questions.get((int)(Math.random()*questions.size()));
                        EmbedBuilder embed = new EmbedBuilder();
                        embed.setTitle("Quiz time!");
                        embed.setDescription("Answer this question correctly to gain 20 primogems!\n(First to get it correct gains 80 primogems!)");
                        embed.addField(question.question,question.choices[0]+"\n"+question.choices[1]+"\n"+question.choices[2]+"\n"+question.choices[3],true);
                        textChannel.sendMessage(embed.build()).queue();
                        List<String>asList = Arrays.asList(question.choices);
                        Collections.shuffle(asList);
                        asList.toArray(question.choices);
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
    static class Question{
        String question;
        String[]choices;
        String answer;
        public Question(String question,String[]choices,String answer){
            this.question = question;
            this.choices = choices;
            this.answer = answer;
        }
    }
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(Objects.isNull(question)){
            return;
        }
        Player player = Tools.getPlayer(event.getAuthor());
        if(answered.contains(player)){
            return;
        }
        if(event.getChannel().equals(textChannel)){
            if(System.currentTimeMillis()-player.time<5000){
                for(String choice:question.choices){
                    if(event.getMessage().getContentRaw().equalsIgnoreCase(choice)){
                        event.getChannel().sendMessage("You can not answer again for 5 seconds after answering incorrectly.").queue();
                    }
                }
                return;
            }
            if(answerable){
                if(event.getMessage().getContentRaw().equalsIgnoreCase(question.answer)){
                    if(first){
                        player.primogems+=80;
                        event.getChannel().sendMessage(event.getAuthor().getName()+" has answered correctly first and was rewarded 80 primogems.").queue();
                        first = false;
                    } else{
                        player.primogems+=20;
                        event.getChannel().sendMessage(event.getAuthor().getName()+" has answered correctly and was rewarded 20 primogems.").queue();
                    }
                    answered.add(player);
                    try {
                        SaveData.saveData();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    for(String choice:question.choices){
                        if(event.getMessage().getContentRaw().equalsIgnoreCase(choice)){
                            player.time = System.currentTimeMillis();
                        }
                    }
                }
            }
        }
    }
}
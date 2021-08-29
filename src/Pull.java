import com.iwebpp.crypto.TweetNaclFast;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Pull extends ListenerAdapter {

    static String[]allWeapons = {
    };

    static String[]threeStars = {
            "Skyrider Sword","Harbinger of Dawn","Cool Steel",
            "Black Tassel",
            "Ferrous Shadow","Debate Club","Bloodtainted Greatsword",
            "Magic Guide","Thrilling Tales of Dragon Slayers","Emerald Orb",
            "Slingshot","Sharpshooter's Oath","Raven Bow"
    };

    static String[]fourStarCharacters = {
            "Amber","Lisa","Kaeya","Barbara","Razor","Bennett","Noelle","Fischl",
            "Sucrose","Beidou","Ningguang","Xiangling","Xingqiu","Chongyun",
            "Diona","Xinyan","Rosaria","Yanfei"
    };
    static String[]fourStarWeapons = {
            "The Flute","The Alley Flash","Sacrificial Sword","Lion's Roar","Favonius Sword",
            "Lithic Spear","Favonius Lance","Dragon's Bane",
            "The Bell","Sacrificial Greatsword","Rainslasher","Lithic Blade","Favonius Greatsword",
            "Wine and Song","The Widsith","Sacrificial Fragments","Favonius Codex","Eye of Perception",
            "The Stringless","Sacrificial Bow","Rust","Mitternachts Waltz","Favonius Warbow","Alley Hunter"
    };

    static String[]fiveStarCharacters = {"Jean", "Diluc", "Mona", "Qiqi", "Keqing"};
    static String[]fiveStarWeapons = {"Skyward Spine","Skyward Harp","Skyward Atlas",
            "Skyward Pride","Skyward Blade","Amos' Bow","Lost Prayer to the Sacred Winds",
            "Primoridal Jade Winged-Spear","Wolf's Gravestone","Aquila Favonia"};

    static String rateUpFiveStar = "Hu Tao";
    static String[]rateUpFourStars = {"Chongyun","Xiangling","Xingqiu"};

    static HashMap<String,String>images = new HashMap<>();
    static{
        images.put("Amber","https://static.wikia.nocookie.net/gensin-impact/images/2/26/Character_Amber_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024042115");
        images.put("Lisa","https://static.wikia.nocookie.net/gensin-impact/images/d/dc/Character_Lisa_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024042621");
        images.put("Kaeya","https://static.wikia.nocookie.net/gensin-impact/images/6/64/Character_Kaeya_Card.jpg/revision/latest/scale-to-width-down/281?cb=20190704215128");
        images.put("Barbara","https://static.wikia.nocookie.net/gensin-impact/images/9/93/Character_Barbara_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024042228");
        images.put("Razor","https://static.wikia.nocookie.net/gensin-impact/images/6/68/Character_Razor_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024043017");
        images.put("Bennett","https://static.wikia.nocookie.net/gensin-impact/images/7/7f/Character_Bennett_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024042332");
        images.put("Noelle","https://static.wikia.nocookie.net/gensin-impact/images/9/92/Character_Noelle_Card.jpg/revision/latest/scale-to-width-down/281?cb=20200403111008");
        images.put("Fischl","https://static.wikia.nocookie.net/gensin-impact/images/4/48/Character_Fischl_Card.jpg/revision/latest/scale-to-width-down/281?cb=20200331202523");
        images.put("Sucrose","https://static.wikia.nocookie.net/gensin-impact/images/2/22/Character_Sucrose_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024043113");
        images.put("Beidou","https://static.wikia.nocookie.net/gensin-impact/images/8/84/Character_Beidou_Card.jpg/revision/latest/scale-to-width-down/281?cb=20200401024902");
        images.put("Ningguang","https://static.wikia.nocookie.net/gensin-impact/images/3/3e/Character_Ningguang_Card.jpg/revision/latest/scale-to-width-down/281?cb=20200401040354");
        images.put("Xiangling","https://static.wikia.nocookie.net/gensin-impact/images/f/f1/Character_Xiangling_Card.jpg/revision/latest/scale-to-width-down/281?cb=20200331191545");
        images.put("Xingqiu","https://static.wikia.nocookie.net/gensin-impact/images/c/c2/Character_Xingqiu_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024043209");
        images.put("Chongyun","https://static.wikia.nocookie.net/gensin-impact/images/f/fa/Character_Chongyun_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024042420");
        images.put("Diona","https://static.wikia.nocookie.net/gensin-impact/images/0/08/Character_Diona_Card.png/revision/latest/scale-to-width-down/281?cb=20201107193459");
        images.put("Xinyan","https://static.wikia.nocookie.net/gensin-impact/images/4/4c/Character_Xinyan_Card.jpeg/revision/latest/scale-to-width-down/281?cb=20201128161752");
        images.put("Rosaria","https://static.wikia.nocookie.net/gensin-impact/images/6/6d/Character_Rosaria_Card.png/revision/latest/scale-to-width-down/281?cb=20210330063015");
        images.put("Yanfei","https://static.wikia.nocookie.net/gensin-impact/images/f/f3/Character_Yanfei_Card.png/revision/latest/scale-to-width-down/281?cb=20210422100113");
        images.put("Jean","https://static.wikia.nocookie.net/gensin-impact/images/0/0e/Character_Jean_Card.jpg/revision/latest/scale-to-width-down/281?cb=20210706133041");
        images.put("Diluc","https://static.wikia.nocookie.net/gensin-impact/images/4/45/Character_Diluc_Card.jpg/revision/latest/scale-to-width-down/281?cb=20210529160947");
        images.put("Mona","https://static.wikia.nocookie.net/gensin-impact/images/6/69/Character_Mona_Card.jpg/revision/latest/scale-to-width-down/281?cb=20210323193416");
        images.put("Qiqi","https://static.wikia.nocookie.net/gensin-impact/images/b/b9/Character_Qiqi_Card.jpg/revision/latest/scale-to-width-down/281?cb=20200904131037");
        images.put("Keqing","https://static.wikia.nocookie.net/gensin-impact/images/f/f4/Character_Keqing_Card.jpg/revision/latest/scale-to-width-down/281?cb=20201024042513");
        images.put("Kamisato Ayaka","https://static.wikia.nocookie.net/gensin-impact/images/3/34/Character_Kamisato_Ayaka_Card.png/revision/latest/scale-to-width-down/281?cb=20210607100828");
        images.put("Venti","https://static.wikia.nocookie.net/gensin-impact/images/7/76/Character_Venti_Card.jpg/revision/latest?cb=20201024042752");
        images.put("Xiao","https://static.wikia.nocookie.net/gensin-impact/images/8/88/Character_Xiao_Card.jpg/revision/latest?cb=20200331193542");
        images.put("Hu Tao","https://static.wikia.nocookie.net/gensin-impact/images/2/22/Character_Hu_Tao_Card.jpg/revision/latest/scale-to-width-down/281?cb=20210227051236");

        images.put("Skyward Harp","https://static.wikia.nocookie.net/gensin-impact/images/1/19/Weapon_Skyward_Harp.png/revision/latest/scale-to-width-down/256?cb=20201116035246");
        images.put("Amos' Bow","https://static.wikia.nocookie.net/gensin-impact/images/d/de/Weapon_Amos%27_Bow.png/revision/latest/scale-to-width-down/256?cb=20201120010513");
        images.put("Skyward Atlas","https://static.wikia.nocookie.net/gensin-impact/images/3/33/Weapon_Skyward_Atlas.png/revision/latest/scale-to-width-down/256?cb=20201116035225");
        images.put("Lost Prayer to the Sacred Winds","https://static.wikia.nocookie.net/gensin-impact/images/9/98/Weapon_Lost_Prayer_to_the_Sacred_Winds.png/revision/latest/scale-to-width-down/256?cb=20201116034132");
        images.put("Skyward Pride","https://static.wikia.nocookie.net/gensin-impact/images/0/0b/Weapon_Skyward_Pride.png/revision/latest/scale-to-width-down/256?cb=20201116035255");
        images.put("Wolf's Gravestone","https://static.wikia.nocookie.net/gensin-impact/images/4/4f/Weapon_Wolf%27s_Gravestone.png/revision/latest/scale-to-width-down/256?cb=20201116035623");
        images.put("Skyward Spine","https://static.wikia.nocookie.net/gensin-impact/images/6/69/Weapon_Skyward_Spine.png/revision/latest/scale-to-width-down/256?cb=20201116035301");
        images.put("Primordial Jade Winged-Spear","https://static.wikia.nocookie.net/gensin-impact/images/8/80/Weapon_Primordial_Jade_Winged-Spear.png/revision/latest/scale-to-width-down/256?cb=20201116152024");
        images.put("Skyward Blade","https://static.wikia.nocookie.net/gensin-impact/images/0/03/Weapon_Skyward_Blade.png/revision/latest/scale-to-width-down/256?cb=20201116035239");
        images.put("Aquila Favonia","https://static.wikia.nocookie.net/gensin-impact/images/6/6a/Weapon_Aquila_Favonia.png/revision/latest/scale-to-width-down/256?cb=20201120002750");
        images.put("Favonius Warbow","https://static.wikia.nocookie.net/gensin-impact/images/8/85/Weapon_Favonius_Warbow.png/revision/latest/scale-to-width-down/256?cb=20201120003145");
        images.put("Sacrificial Bow","https://static.wikia.nocookie.net/gensin-impact/images/e/ec/Weapon_Sacrificial_Bow.png/revision/latest/scale-to-width-down/256?cb=20201120002607");
        images.put("The Stringless","https://static.wikia.nocookie.net/gensin-impact/images/7/71/Weapon_The_Stringless.png/revision/latest/scale-to-width-down/256?cb=20201116035406");
        images.put("Rust","https://static.wikia.nocookie.net/gensin-impact/images/1/1c/Weapon_Rust.png/revision/latest/scale-to-width-down/256?cb=20201120002437");
        images.put("Favonius Codex","https://static.wikia.nocookie.net/gensin-impact/images/3/36/Weapon_Favonius_Codex.png/revision/latest/scale-to-width-down/256?cb=20201116033719");
        images.put("Sacrificial Fragments","https://static.wikia.nocookie.net/gensin-impact/images/6/6c/Weapon_Sacrificial_Fragments.png/revision/latest/scale-to-width-down/256?cb=20201116035037");
        images.put("The Widsith","https://static.wikia.nocookie.net/gensin-impact/images/f/f0/Weapon_The_Widsith.png/revision/latest/scale-to-width-down/256?cb=20201119201814");
        images.put("Eye of Perception","https://static.wikia.nocookie.net/gensin-impact/images/6/6c/Weapon_Eye_of_Perception.png/revision/latest/scale-to-width-down/256?cb=20201116033703");
        images.put("Favonius Greatsword","https://static.wikia.nocookie.net/gensin-impact/images/9/9c/Weapon_Favonius_Greatsword.png/revision/latest/scale-to-width-down/256?cb=20201119235934");
        images.put("Sacrificial Greatsword","https://static.wikia.nocookie.net/gensin-impact/images/1/17/Weapon_Sacrificial_Greatsword.png/revision/latest/scale-to-width-down/256?cb=20201120004023");
        images.put("The Bell","https://static.wikia.nocookie.net/gensin-impact/images/6/6e/Weapon_The_Bell.png/revision/latest/scale-to-width-down/256?cb=20201116035344");
        images.put("Rainslasher","https://static.wikia.nocookie.net/gensin-impact/images/d/d4/Weapon_Rainslasher.png/revision/latest/scale-to-width-down/256?cb=20201119235128");
        images.put("Favonius Lance","https://static.wikia.nocookie.net/gensin-impact/images/5/57/Weapon_Favonius_Lance.png/revision/latest/scale-to-width-down/256?cb=20201116154512");
        images.put("Dragon's Bane","https://static.wikia.nocookie.net/gensin-impact/images/2/24/Weapon_Dragon%27s_Bane.png/revision/latest/scale-to-width-down/256?cb=20201116033629");
        images.put("Favonius Sword","https://static.wikia.nocookie.net/gensin-impact/images/9/90/Weapon_Favonius_Sword.png/revision/latest/scale-to-width-down/256?cb=20201116033811");
        images.put("Sacrificial Sword","https://static.wikia.nocookie.net/gensin-impact/images/a/a0/Weapon_Sacrificial_Sword.png/revision/latest/scale-to-width-down/256?cb=20201120010840");
        images.put("The Flute","https://static.wikia.nocookie.net/gensin-impact/images/6/63/Weapon_The_Flute.png/revision/latest/scale-to-width-down/256?cb=20201119203316");
        images.put("Lion's Roar","https://static.wikia.nocookie.net/gensin-impact/images/e/e6/Weapon_Lion%27s_Roar.png/revision/latest/scale-to-width-down/256?cb=20201119232745");
        images.put("Slingshot","https://static.wikia.nocookie.net/gensin-impact/images/c/ca/Weapon_Slingshot.png/revision/latest/scale-to-width-down/256?cb=20201116035308");
        images.put("Sharpshooter's Oath","https://static.wikia.nocookie.net/gensin-impact/images/5/52/Weapon_Sharpshooter%27s_Oath.png/revision/latest/scale-to-width-down/256?cb=20201116035135");
        images.put("Raven Bow","https://static.wikia.nocookie.net/gensin-impact/images/d/d0/Weapon_Raven_Bow.png/revision/latest/scale-to-width-down/256?cb=20201116034840");
        images.put("Emerald Orb","https://static.wikia.nocookie.net/gensin-impact/images/7/7c/Weapon_Emerald_Orb.png/revision/latest/scale-to-width-down/256?cb=20201120003056");
        images.put("Thrilling Tales of Dragon Slayers","https://static.wikia.nocookie.net/gensin-impact/images/1/19/Weapon_Thrilling_Tales_of_Dragon_Slayers.png/revision/latest/scale-to-width-down/256?cb=20201119201736");
        images.put("Magic Guide","https://static.wikia.nocookie.net/gensin-impact/images/3/39/Weapon_Magic_Guide.png/revision/latest/scale-to-width-down/256?cb=20201119232047");
        images.put("Debate Club","https://static.wikia.nocookie.net/gensin-impact/images/7/74/Weapon_Debate_Club.png/revision/latest/scale-to-width-down/256?cb=20201116033616");
        images.put("Bloodtainted Greatsword","https://static.wikia.nocookie.net/gensin-impact/images/4/4a/Weapon_Bloodtainted_Greatsword.png/revision/latest/scale-to-width-down/256?cb=20201119233531");
        images.put("Ferrous Shadow","https://static.wikia.nocookie.net/gensin-impact/images/e/e9/Weapon_Ferrous_Shadow.png/revision/latest/scale-to-width-down/256?cb=20201120003242");
        images.put("Black Tassel","https://static.wikia.nocookie.net/gensin-impact/images/4/43/Weapon_Black_Tassel.png/revision/latest/scale-to-width-down/256?cb=20201116033134");
        images.put("Skyrider Sword","https://static.wikia.nocookie.net/gensin-impact/images/3/34/Weapon_Skyrider_Sword.png/revision/latest/scale-to-width-down/256?cb=20201116035206");
        images.put("Harbinger of Dawn","https://static.wikia.nocookie.net/gensin-impact/images/2/23/Weapon_Harbinger_of_Dawn.png/revision/latest/scale-to-width-down/256?cb=20201119233056");
        images.put("Cool Steel","https://static.wikia.nocookie.net/gensin-impact/images/9/9c/Weapon_Cool_Steel.png/revision/latest/scale-to-width-down/256?cb=20201119233444");
    }

    static GuildMessageReceivedEvent event;
    static EmbedBuilder embed;
    static Player player;

    //-----------------------------------------------------------------------------------------------

    public static void main(GuildMessageReceivedEvent event, String[]args){
        embed = new EmbedBuilder();
        Pull.event = event;
        player = Tools.getPlayer(event.getAuthor());
        if(args.length>1){
            switch (args[1].toLowerCase()) {
                case "standard" -> {
                    String pull = permanentBannerPull();
                    addToInventory(pull);
                    player.history.add(pull);
                    player.limitedHistory.add(pull);
                    embed.setTitle("Standard Wish Results:");
                    embed.setDescription(event.getAuthor().getName() + " pulled a " + pull + "!\n" + getNumStars(pull));
                    if (!(images.get(pull) == null)) {
                        embed.setImage(images.get(pull));
                    }
                    try {
                        SaveData.saveData(player);
                    } catch (Exception ignored) {}
                }
                case "limited", "event" -> {
                    String pull = limitedBannerPull();
                    addToInventory(pull);
                    player.history.add(pull);
                    player.limitedHistory.add(pull);
                    embed.setTitle("Character Event Wish Results:");
                    embed.setDescription(event.getAuthor().getName() + " pulled a " + pull + "!\n" + getNumStars(pull));
                    if (!(images.get(pull) == null)) {
                        embed.setImage(images.get(pull));
                    }
                    try {
                        SaveData.saveData(player);
                    } catch (Exception ignored) {}
                }
                /*case "history" -> {
                    if(args.length>2){
                        if(args[2].equalsIgnoreCase("standard")){
                            embed.setTitle("In development");
                        }else if(args[2].equalsIgnoreCase("event")||args[2].equalsIgnoreCase("limited")){
                            embed.setTitle(event.getAuthor().getName()+"'s Event Wish History:");
                            embed.addField("Item Type",Pull.getHistory("type",1,"Event"),true);
                            embed.addField("Item Name",Pull.getHistory("name",1,"Event"),true);
                            //embed.addField("Time Received",Pull.getHistory("time"),true);
                        }
                        else{
                            //To implement overall history
                            embed.setTitle("In development");
                        }
                    }
                    else{
                        //To implement overall history
                        embed.setTitle("In development");
                    }
                }

                 */
                default -> {
                    embed.setTitle("Pull Help");
                    embed.setDescription("Use `" + Main.prefix + "pull <Banner Name>` to pull!");
                    embed.addField("Available Banners:", "Standard\nEvent", false);
                }
            }
        }
        else{
            embed.setTitle("Pull Help");
            embed.setDescription("Use `"+Main.prefix+"pull <Banner Name>` to pull!");
            embed.addField("Available Banners:","Standard\nEvent",false);
        }
        event.getChannel().sendMessage(embed.build()).queue();
    }

    public static String permanentBannerPull(){
        Random rand = new Random();
        int pity = player.standardPity;
        int pity4star = player.standardPity4star;
        double rng = rand.nextDouble();
        double rate5star = 0.006;
        double rate4star = 0.057;
        if(pity==89){
            rate5star=1;
        }
        else if(pity>70){
            rate5star+=0.194;
            rate4star+=0.194;
        }
        if(pity4star==9){
            rate4star=1;
        }

        if(rng<rate5star){
            player.standardPity = 0;
            player.standardPity4star = 0;
            boolean character = rand.nextBoolean();
            if(character){
                return fiveStarCharacters[rand.nextInt(fiveStarCharacters.length)];
            }
            return fiveStarWeapons[rand.nextInt(fiveStarWeapons.length)];
        }else if(rng<rate4star){
            player.standardPity4star = 0;
            boolean character = rand.nextBoolean();
            if(character){
                return fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
            }
            return fourStarWeapons[rand.nextInt(fourStarWeapons.length)];
        }else{
            player.standardPity++;
            player.standardPity4star++;
            return threeStars[rand.nextInt(threeStars.length)];
        }
    }

    public static String limitedBannerPull(){
        Random rand = new Random();
        int pity = player.limitedPity;
        int pity4star = player.limitedPity4Star;
        double rng = rand.nextDouble();
        double rate5star = 0.006;
        double rate4star = 0.057;
        if(pity==89){
            rate5star=1;
        }
        else if(pity>70){
            rate5star+=0.194;
            rate4star+=0.194;
        }
        if(pity4star==9){
            rate4star=1;
        }

        if(rng<rate5star){
            player.limitedPity = 0;
            player.limitedPity4Star = 0;
            if(player.fiftyfifty){
                if(!rand.nextBoolean()){
                    player.fiftyfifty = false;
                    return fiveStarCharacters[rand.nextInt(fiveStarCharacters.length)];
                }
            }
            player.fiftyfifty = true;
            return rateUpFiveStar;
        }else if(rng<rate4star){
            player.limitedPity4Star = 0;
            if(rand.nextInt()<0.75){
                return rateUpFourStars[rand.nextInt(rateUpFourStars.length)];
            }
            boolean character = rand.nextBoolean();
            if(character){
                String fourStar = fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
                while(Arrays.asList(rateUpFourStars).contains(fourStar)){
                    fourStar = fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
                }
                return fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
            }
            return fourStarWeapons[rand.nextInt(fourStarWeapons.length)];
        }else{
            player.limitedPity++;
            player.limitedPity4Star++;
            return threeStars[rand.nextInt(threeStars.length)];
        }
    }

    public static void addToInventory(String key){
        if(player.inventory.containsKey(key)){
            player.inventory.put(key,player.inventory.get(key)+1);
        } else{
            player.inventory.put(key,1);
        }
    }

    public static String getNumStars(String key){
        if(Arrays.asList(threeStars).contains(key)){
            Pull.embed.setColor(new Color(43, 139, 255));
            return ":star::star::star:";
        }
        else if(Arrays.asList(fourStarCharacters).contains(key)||Arrays.asList(fourStarWeapons).contains(key)){
            Pull.embed.setColor(new Color(190, 10, 255));
            return ":star::star::star::star:";
        }
        else{
            Pull.embed.setColor(new Color(255,215,0));
            return ":star::star::star::star::star:";
        }
    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent reaction){
        if(reaction.getReactionEmote().getName().equals(":arrow_forward:")&&reaction.getMember().getUser().equals(Pull.event.getAuthor())){

        }
    }

    /*public static String getHistory(String type,int pagenum,String banner){
        StringBuilder page = new StringBuilder();
        switch(type){
            case "type" -> {
                if(banner.equals("Standard")){
                    for(int i=player.standardHistory.size()-1-((pagenum-1)*10);i>=player.standardHistory.size()-1-((pagenum-1)*10)-10&&i>=0;i--){
                        if(Arrays.asList(threeStars).contains(player.standardHistory.get(i))||){
                            page.append("Weapon\n");
                        }
                    }
                }else if(banner.equals("Event")){
                    for(int i=player.limitedHistory.size()-1-((pagenum-1)*10);i>=player.limitedHistory.size()-1-((pagenum-1)*10)-10&&i>=0;i--){
                }
                else{

                }
            }
        }
        return "In Development";
    }

     */
}

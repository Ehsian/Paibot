import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Wish extends ListenerAdapter {

    static String[]allWeapons = {
            "Skyrider Sword","Harbinger of Dawn","Cool Steel",
            "Black Tassel",
            "Ferrous Shadow","Debate Club","Bloodtainted Greatsword",
            "Magic Guide","Thrilling Tales of Dragon Slayers","Emerald Orb",
            "Slingshot","Sharpshooter's Oath","Raven Bow",
            "The Flute","The Alley Flash","Sacrificial Sword","Lion's Roar","Favonius Sword",
            "Lithic Spear","Favonius Lance","Dragon's Bane",
            "The Bell","Sacrificial Greatsword","Rainslasher","Lithic Blade","Favonius Greatsword",
            "Wine and Song","The Widsith","Sacrificial Fragments","Favonius Codex","Eye of Perception",
            "The Stringless","Sacrificial Bow","Rust","Mitternachts Waltz","Favonius Warbow","Alley Hunter",
            "Skyward Spine","Skyward Harp","Skyward Atlas",
            "Skyward Pride","Skyward Blade","Amos' Bow","Lost Prayer to the Sacred Winds",
            "Primoridal Jade Winged-Spear","Wolf's Gravestone","Aquila Favonia"
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
            "Diona","Xinyan","Rosaria","Yanfei","Kujou Sara","Yun Jin"
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
            "Primordial Jade Winged-Spear","Wolf's Gravestone","Aquila Favonia"};

    static String rateUpFiveStar = "Shenhe";
    static String[]rateUpFourStars = {"Yun Jin","Bennett","Xingqiu"};

    static HashMap<String,String>images = new HashMap<>();
    static{
        images.put("Amber","https://genshin.honeyhunterworld.com/img/char/amber_gacha_splash.png");
        images.put("Lisa","https://genshin.honeyhunterworld.com/img/char/lisa_gacha_splash.png");
        images.put("Kaeya","https://genshin.honeyhunterworld.com/img/char/kaeya_gacha_splash.png");
        images.put("Barbara","https://genshin.honeyhunterworld.com/img/char/barbara_gacha_splash.png");
        images.put("Razor","https://genshin.honeyhunterworld.com/img/char/razor_gacha_splash.png");
        images.put("Bennett","https://genshin.honeyhunterworld.com/img/char/bennett_gacha_splash.png");
        images.put("Noelle","https://genshin.honeyhunterworld.com/img/char/noelle_gacha_splash.png");
        images.put("Fischl","https://genshin.honeyhunterworld.com/img/char/fischl_gacha_splash.png");
        images.put("Sucrose","https://genshin.honeyhunterworld.com/img/char/sucrose_gacha_splash.png");
        images.put("Beidou","https://genshin.honeyhunterworld.com/img/char/beidou_gacha_splash.png");
        images.put("Ningguang","https://genshin.honeyhunterworld.com/img/char/ningguang_gacha_splash.png");
        images.put("Xiangling","https://genshin.honeyhunterworld.com/img/char/xiangling_gacha_splash.png");
        images.put("Xingqiu","https://genshin.honeyhunterworld.com/img/char/xingqiu_gacha_splash.png");
        images.put("Chongyun","https://genshin.honeyhunterworld.com/img/char/chongyun_gacha_splash.png");
        images.put("Diona","https://genshin.honeyhunterworld.com/img/char/diona_gacha_splash.png");
        images.put("Xinyan","https://genshin.honeyhunterworld.com/img/char/xinyan_gacha_splash.png");
        images.put("Rosaria","https://genshin.honeyhunterworld.com/img/char/rosaria_gacha_splash.png");
        images.put("Yanfei","https://genshin.honeyhunterworld.com/img/char/yanfei_gacha_splash.png");
        images.put("Kujou Sara","https://genshin.honeyhunterworld.com/img/char/sara_gacha_splash.png");
        images.put("Thoma","https://genshin.honeyhunterworld.com/img/char/thoma_gacha_splash.png");

        images.put("Jean","https://genshin.honeyhunterworld.com/img/char/jean_gacha_splash.png");
        images.put("Diluc","https://genshin.honeyhunterworld.com/img/char/diluc_gacha_splash.png");
        images.put("Mona","https://genshin.honeyhunterworld.com/img/char/mona_gacha_splash.png");
        images.put("Qiqi","https://genshin.honeyhunterworld.com/img/char/qiqi_gacha_splash.png");
        images.put("Keqing","https://genshin.honeyhunterworld.com/img/char/keqing_gacha_splash.png");
        images.put("Kamisato Ayaka","https://genshin.honeyhunterworld.com/img/char/ayaka_gacha_splash.png");
        images.put("Venti","https://genshin.honeyhunterworld.com/img/char/venti_gacha_splash.png");
        images.put("Xiao","https://genshin.honeyhunterworld.com/img/char/xiao_gacha_splash.png");
        images.put("Hu Tao","https://genshin.honeyhunterworld.com/img/char/hutao_gacha_splash.png");
        images.put("Raiden Shogun","https://genshin.honeyhunterworld.com/img/char/shougun_gacha_splash.png");
        images.put("Sangonomiya Kokomi","https://genshin.honeyhunterworld.com/img/char/kokomi_gacha_splash.png");

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
        images.put("Alley Hunter","https://static.wikia.nocookie.net/gensin-impact/images/0/0a/Weapon_Alley_Hunter.png/revision/latest/scale-to-width-down/256?cb=20210413212830");
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
        images.put("The Alley Flash","https://static.wikia.nocookie.net/gensin-impact/images/8/83/Weapon_The_Alley_Flash.png/revision/latest/scale-to-width-down/256?cb=20210317151138");
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

        //Replace when actual character comes out
        images.put("Yun Jin","https://genshin.honeyhunterworld.com/img/char/yunjin_gacha_splash.png");
        images.put("Shenhe","https://genshin.honeyhunterworld.com/img/char/shenhe_gacha_splash.png");
    }

    static GuildMessageReceivedEvent event;
    static EmbedBuilder embed;
    static Player player;

    //-----------------------------------------------------------------------------------------------

    public static void main(GuildMessageReceivedEvent event, String[]args){
        embed = new EmbedBuilder();
        Wish.event = event;
        player = Tools.getPlayer(event.getAuthor());
        if(args.length>1){
            switch (args[1].toLowerCase()) {
                case "standard" -> {
                    if(args.length>2&&args[2].equals("10")){
                        if(player.acquaintfate<10){
                            event.getChannel().sendMessage("You do not have enough Acquaint Fates! Purchase more at )shop.").queue();
                            return;
                        }
                        boolean containsFiveStar = false;
                        embed.setTitle("Standard Wish (x10) Results:");
                        for(int i=0;i<10;i++){
                            player.acquaintfate--;
                            String Wish = permanentBannerWish();
                            addToInventory(Wish,"standard");
                            try {
                                SaveData.saveData(player);
                            } catch (Exception ignored) {}
                            embed.addField("Pull #"+(i+1)+":",getNumStars(Wish)+" "+player.standardHistory.get(0).type+" - "+Wish,false);
                            if(getNumStars(Wish).equals(":star::star::star::star::star:")){
                                containsFiveStar = true;
                            }
                        }
                        if(containsFiveStar){
                            embed.setColor(new Color(255,215,0));
                        }else{
                            embed.setColor(new Color(190, 10, 255));
                        }
                        break;
                    }
                    if(player.acquaintfate<1){
                        event.getChannel().sendMessage("You do not have enough Acquaint Fates! Purchase more at )shop.").queue();
                        return;
                    }
                    player.acquaintfate--;
                    String Wish = permanentBannerWish();
                    addToInventory(Wish,"standard");
                    embed.setTitle("Standard Wish Results:");
                    embed.setDescription(event.getAuthor().getName() + " pulled a " + Wish + "!\n" + getNumStars(Wish));
                    if (!(images.get(Wish) == null)) {
                        embed.setImage(images.get(Wish));
                    }
                    try {
                        SaveData.saveData(player);
                    } catch (Exception ignored) {}
                }
                case "limited", "event" -> {
                    if(args.length>2&&args[2].equals("10")){
                        if(player.intertwinedfate<10){
                            event.getChannel().sendMessage("You do not have enough Intertwined Fates! Purchase more at )shop.").queue();
                            return;
                        }
                        boolean containsFiveStar = false;
                        embed.setTitle("Character Event Wish (x10) Results:");
                        for(int i=0;i<10;i++){
                            player.intertwinedfate--;
                            String Wish = limitedBannerWish();
                            addToInventory(Wish,"event");
                            try {
                                SaveData.saveData(player);
                            } catch (Exception ignored) {}
                            embed.addField("Pull #"+(i+1)+":",getNumStars(Wish)+" "+player.limitedHistory.get(0).type+" - "+Wish,false);
                            if(getNumStars(Wish).equals(":star::star::star::star::star:")){
                                containsFiveStar = true;
                            }
                        }
                        if(containsFiveStar){
                            embed.setColor(new Color(255,215,0));
                        }else{
                            embed.setColor(new Color(190, 10, 255));
                        }
                        break;
                    }
                    if(player.intertwinedfate<1){
                        event.getChannel().sendMessage("You do not have enough Intertwined Fates! Purchase more at )shop.").queue();
                        return;
                    }
                    player.intertwinedfate--;
                    String Wish = limitedBannerWish();
                    addToInventory(Wish,"event");
                    embed.setTitle("Character Event Wish Results:");
                    embed.setDescription(event.getAuthor().getName() + " pulled a " + Wish + "!\n" + getNumStars(Wish));
                    if (!(images.get(Wish) == null)) {
                        embed.setImage(images.get(Wish));
                    }
                    try {
                        SaveData.saveData(player);
                    } catch (Exception ignored) {}
                }
                case "history" -> {
                    if(args.length>2){
                        if(args[2].equalsIgnoreCase("standard")){
                            int page = 1;
                            if(args.length>3){
                                try{
                                    page = Integer.parseInt(args[3]);
                                    if(page>player.standardHistory.size()/10+1||page==0){
                                        event.getChannel().sendMessage("Please input a valid page number. ("+1+"-"+(player.standardHistory.size()/10+1)+")").queue();
                                        return;
                                    }
                                }catch(NumberFormatException e){
                                    event.getChannel().sendMessage("Please input a valid page number. ("+1+"-"+(player.standardHistory.size()/10+1)+")").queue();
                                    return;
                                }
                            }
                            embed.setTitle(event.getAuthor().getName()+"'s Standard Wish History:");
                            embed.addField("Item Type",Wish.getHistory("type",page,"standard"),true);
                            embed.addField("Item Name",Wish.getHistory("name",page,"standard"),true);
                            embed.addField("Time Received",Wish.getHistory("time",page,"standard"),true);
                            embed.setFooter("Page "+page+" of "+(player.standardHistory.size()/10+1));
                        }else if(args[2].equalsIgnoreCase("event")||args[2].equalsIgnoreCase("limited")){
                            int page = 1;
                            if(args.length>3){
                                try{
                                    page = Integer.parseInt(args[3]);
                                    if(page>player.limitedHistory.size()/10+1||page==0){
                                        event.getChannel().sendMessage("Please input a valid page number. ("+1+"-"+(player.limitedHistory.size()/10+1)+")").queue();
                                        return;
                                    }
                                }catch(NumberFormatException e){
                                    event.getChannel().sendMessage("Please input a valid page number. ("+1+"-"+(player.limitedHistory.size()/10+1)+")").queue();
                                    return;
                                }
                            }
                            embed.setTitle(event.getAuthor().getName()+"'s Event Wish History:");
                            embed.addField("Item Type",Wish.getHistory("type",page,"event"),true);
                            embed.addField("Item Name",Wish.getHistory("name",page,"event"),true);
                            embed.addField("Time Received",Wish.getHistory("time",page,"event"),true);
                            embed.setFooter("Page "+page+" of "+(player.limitedHistory.size()/10+1));
                        }
                        else{
                            event.getChannel().sendMessage("Unknown Banner.\nAvailable banners - `standard`,`event`.").queue();
                        }
                        embed.setColor(0);
                    }
                    else{
                        //To implement overall history
                        embed.setTitle("In development");
                    }
                }
                default -> {
                    embed.setTitle("Wish Help");
                    embed.setDescription("Use `" + Main.prefix + "Wish <Banner Name>` to Wish!");
                    embed.addField("Available Banners:", "Standard\nEvent", false);
                }
            }
        }
        else{
            embed.setTitle("Wish Help");
            embed.setDescription("Use `"+Main.prefix+"Wish <Banner Name>` to Wish!");
            embed.addField("Available Banners:","Standard\nEvent",false);
        }
        event.getChannel().sendMessage(embed.build()).queue();
    }

    public static String permanentBannerWish(){
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
                String item = fiveStarCharacters[rand.nextInt(fiveStarCharacters.length)];
                if(player.inventory.containsKey(item)){
                    if(player.inventory.get(item)<=7){ //c0 - c6 (7 Total copies)
                        player.starglitter+=10;
                    }
                    else{
                        player.starglitter+=25;
                    }
                }
                return item;
            }
            player.starglitter+=10;
            return fiveStarWeapons[rand.nextInt(fiveStarWeapons.length)];
        }else if(rng<rate4star){
            player.standardPity4star = 0;
            boolean character = rand.nextBoolean();
            if(character){
                String item = fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
                if(player.inventory.containsKey(item)){
                    if(player.inventory.get(item)<=7){ //c0 - c6 (7 Total copies)
                        player.starglitter+=2;
                    }
                    else{
                        player.starglitter+=5;
                    }
                }
                return item;
            }
            player.starglitter+=2;
            return fourStarWeapons[rand.nextInt(fourStarWeapons.length)];
        }else{
            player.standardPity++;
            player.standardPity4star++;
            player.stardust+=15;
            return threeStars[rand.nextInt(threeStars.length)];
        }
    }

    public static String limitedBannerWish(){
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
                    String item = fiveStarCharacters[rand.nextInt(fiveStarCharacters.length)];
                    if(player.inventory.containsKey(item)){
                        if(player.inventory.get(item)<=7){ //c0 - c6 (7 Total copies)
                            player.starglitter+=10;
                        }
                        else{
                            player.starglitter+=25;
                        }
                    }
                    return item;
                }
            }
            player.fiftyfifty = true;
            if(player.inventory.containsKey(rateUpFiveStar)){
                if(player.inventory.get(rateUpFiveStar)<=7){ //c0 - c6 (7 Total copies)
                    player.starglitter+=10;
                }
                else{
                    player.starglitter+=25;
                }
            }
            return rateUpFiveStar;
        }
        else if(rng<rate4star){
            player.limitedPity4Star = 0;
            if(rand.nextInt()<0.75){
                String item = rateUpFourStars[rand.nextInt(rateUpFourStars.length)];
                if(player.inventory.containsKey(item)){
                    if(player.inventory.get(item)<=7){ //c0 - c6 (7 Total copies)
                        player.starglitter+=2;
                    }
                    else{
                        player.starglitter+=5;
                    }
                }
                return item;
            }
            boolean character = rand.nextBoolean();
            if(character){
                String fourStar = fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
                while(Arrays.asList(rateUpFourStars).contains(fourStar)){
                    fourStar = fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
                }
                String item = fourStarCharacters[rand.nextInt(fourStarCharacters.length)];
                if(player.inventory.containsKey(item)){
                    if(player.inventory.get(item)<=7){ //c0 - c6 (7 Total copies)
                        player.starglitter+=2;
                    }
                    else{
                        player.starglitter+=5;
                    }
                }
                return item;
            }
            return fourStarWeapons[rand.nextInt(fourStarWeapons.length)];
        }else{
            player.limitedPity++;
            player.limitedPity4Star++;
            player.stardust+=15;
            return threeStars[rand.nextInt(threeStars.length)];
        }
    }

    public static void addToInventory(String itemname,String banner){
        String type;
        if(Arrays.asList(allWeapons).contains(itemname)){
            type = "Weapon";
        } else{
            type = "Character";
        }
        if(player.inventory.containsKey(itemname)){
            player.inventory.put(itemname,player.inventory.get(itemname)+1);
        } else{
            player.inventory.put(itemname,1);
        }
        player.history.add(0,new Pull(type,itemname));
        switch (banner) {
            case "standard" -> player.standardHistory.add(0,new Pull(type, itemname));
            case "event" -> player.limitedHistory.add(0,new Pull(type, itemname));
        }
    }

    public static String getNumStars(String key){
        if(Arrays.asList(threeStars).contains(key)){
            Wish.embed.setColor(new Color(43, 139, 255));
            return ":star::star::star:";
        }
        else if(Arrays.asList(fourStarCharacters).contains(key)||Arrays.asList(fourStarWeapons).contains(key)){
            Wish.embed.setColor(new Color(190, 10, 255));
            return ":star::star::star::star:";
        }
        else{
            Wish.embed.setColor(new Color(255,215,0));
            return ":star::star::star::star::star:";
        }
    }

    public static String getHistory(String type,int pagenum,String banner){
        StringBuilder page = new StringBuilder();
        if(banner.equalsIgnoreCase("standard")){
            switch(type){
                case "type" -> {
                    for(int i=(pagenum-1)*10;i<(pagenum-1)*10+10&&i<player.standardHistory.size();i++){
                        page.append(getNumStars(player.standardHistory.get(i).name)).append(" ").append(player.standardHistory.get(i).type).append("\n");
                    }
                }
                case "name" -> {
                    for(int i=(pagenum-1)*10;i<(pagenum-1)*10+10&&i<player.standardHistory.size();i++){
                        page.append(player.standardHistory.get(i).name).append("\n");
                    }
                }
                case "time" -> {
                    for(int i=(pagenum-1)*10;i<(pagenum-1)*10+10&&i<player.standardHistory.size();i++){
                        page.append(player.standardHistory.get(i).time).append("\n");
                    }
                }
            }
        }else if(banner.equalsIgnoreCase("event")){
            switch(type){
                case "type" -> {
                    for(int i=(pagenum-1)*10;i<(pagenum-1)*10+10&&i<player.limitedHistory.size();i++){
                        page.append(getNumStars(player.limitedHistory.get(i).name)).append(" ").append(player.limitedHistory.get(i).type).append("\n");
                    }
                }
                case "name" -> {
                    for(int i=(pagenum-1)*10;i<(pagenum-1)*10+10&&i<player.limitedHistory.size();i++){
                        page.append(player.limitedHistory.get(i).name).append("\n");
                    }
                }
                case "time" -> {
                    for(int i=(pagenum-1)*10;i<(pagenum-1)*10+10&&i<player.limitedHistory.size();i++){
                        page.append(player.limitedHistory.get(i).time).append("\n");
                    }
                }
            }
        }
        return page.toString();
    }
}

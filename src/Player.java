import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Serializable {
    String userID;
    boolean daily = false; //false = uncollected, true = collected
    long time; //Last time a wrong answer was inputted (Quiz)
    int primogems = 1000;
    int acquaintfate = 1000000000;
    int intertwinedfate = 1000000000;
    int starglitter = 0;
    int stardust = 0;
    int standardPity = 0;
    int standardPity4star = 0;
    int limitedPity = 0;
    int limitedPity4Star = 0;
    boolean fiftyfifty = true;
    ArrayList<Pull>history = new ArrayList<>();
    ArrayList<Pull>limitedHistory = new ArrayList<>();
    ArrayList<Pull>standardHistory = new ArrayList<>();
    HashMap<String,Integer>inventory = new HashMap<>();

    public Player(String userID){
        this.userID = userID;
    }

}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Serializable {
    String userID;
    int primogems = 1000;
    int starglitter = 0;
    int stardust = 0;
    int standardPity = 0;
    int standardPity4star = 0;
    int limitedPity = 0;
    int limitedPity4Star = 0;
    boolean fiftyfifty = true;
    ArrayList<String>history = new ArrayList<>();
    ArrayList<String>limitedHistory = new ArrayList<>();
    ArrayList<String>standardHistory = new ArrayList<>();
    HashMap<String,Integer>inventory = new HashMap<>();

    public Player(String userID){
        this.userID = userID;
    }

}

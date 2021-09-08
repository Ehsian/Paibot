import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.Serializable;
public class Pull implements Serializable{
    String type;
    String name;
    String time;
    public Pull(String type,String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.type = type;
        this.name = name;
        this.time = dtf.format(now);
    }
}

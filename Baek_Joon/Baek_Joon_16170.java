import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Baek_Joon_16170 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String[] today = sdf.format(c.getTime()).split("-");

        System.out.println(today[0]);
        System.out.println(today[1]);
        System.out.println(today[2]);
    }
    
}

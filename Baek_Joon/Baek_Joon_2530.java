import java.io.IOException;
import java.util.Scanner;

public class Baek_Joon_2530 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt()*60*60 + sc.nextInt()*60 + sc.nextInt() + sc.nextInt();
        int hour = time/60/60%24;
        int min = time/60%60;
        int second = time%60;

        System.out.println(hour +" "+ min +" "+ second);
    }
}

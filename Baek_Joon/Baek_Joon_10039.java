import java.util.*;

public class Baek_Joon_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int avg = 0;
        for(int i = 0; i < 5; i++) {
            int score = sc.nextInt();
            if(score < 40) avg += 40;
            else avg += score;
        }
        System.out.println(avg/5);
    }
}

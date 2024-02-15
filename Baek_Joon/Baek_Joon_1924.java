import java.io.*;

public class Baek_Joon_1924 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] date = br.readLine().split(" ");
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] month_sum_day = {31,28,31,30,31,30,31,31,30,31,30,31};

        int sum_day = 0;
        for(int i = 0; i < Integer.parseInt(date[0])-1; i++) {
            sum_day += month_sum_day[i];
        }
        sum_day += Integer.parseInt(date[1]);
        int idx = sum_day%7 - 1;
        if(idx < 0) idx = days.length - 1;
        System.out.println(days[idx]);
    }
}

import java.io.*;
import java.util.Arrays;

public class Baek_Joon_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        
        String[] person = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(person[i]);
        }

        Arrays.sort(time);

        int time_min = 0;
        for(int i = 0; i < time.length; i++) {
            if(i == 0) time_min = time[i];
            else {
                time_min += time[i-1] + time[i];
                time[i] += time[i-1];
            }
        }

        System.out.println(time_min);
    }
}

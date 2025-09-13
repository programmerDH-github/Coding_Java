import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] time = new String[N];
        for(int i = 0; i < N; i++) {
            time[i] = br.readLine();
        }

        Arrays.sort(time);

        int start = 10*60;
        int end = 22*60;
        int max = 0;
        for(int i = 0; i < N; i++) {
            String[] s_e = time[i].split(" ");
            String[] startTime = s_e[0].split("");
            String[] endTime = s_e[1].split("");            
            
            int startTimeMin = Integer.parseInt(startTime[0]+startTime[1]) * 60 + Integer.parseInt(startTime[2]+startTime[3]);
            int endTimeMin = Integer.parseInt(endTime[0]+endTime[1]) * 60 + Integer.parseInt(endTime[2]+endTime[3]);

            System.out.println(startTimeMin - start);

            if(startTimeMin - start - 10 > 0) {
                max = Math.max(max, startTimeMin-start-10);
            }

            start = endTimeMin;

            if(i == N-1 && end-start-10 > 0) {
                max = Math.max(max, end-start-10);
            }

        }

        System.out.println(max);

    }
}

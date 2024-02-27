import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] start_end = br.readLine().split(" ");
            int start = Integer.parseInt(start_end[0]);
            int end = Integer.parseInt(start_end[1]);

            times[i][0] = start;
            times[i][1] = end;
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int time = 0;
        for(int i = 0; i < times.length; i++) {
            if(time <= times[i][0]) {
                time = times[i][1];
                count++;
            }
        }
        System.out.println(count);
        
    }
}

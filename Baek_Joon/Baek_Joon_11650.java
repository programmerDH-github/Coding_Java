import java.io.*;
import java.util.*;

public class Baek_Joon_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dot = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] x_y = br.readLine().split(" ");
            dot[i][0] = Integer.parseInt(x_y[0]);
            dot[i][1] = Integer.parseInt(x_y[1]);
        }

        Arrays.sort(dot, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.println(dot[i][0] +" "+ dot[i][1]);
        }
    }
}

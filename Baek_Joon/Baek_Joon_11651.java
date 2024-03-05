import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        int[][] coordinate = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] x_y = br.readLine().split(" ");
            int x = Integer.parseInt(x_y[0]);
            int y = Integer.parseInt(x_y[1]);
            
            coordinate[i][0] = x;
            coordinate[i][1] = y;
        }

        Arrays.sort(coordinate, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < N; i++) {
            sb.append(coordinate[i][0]).append(" ").append(coordinate[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}

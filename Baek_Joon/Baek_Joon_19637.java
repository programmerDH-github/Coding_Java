import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Baek_Joon_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        String[][] title = new String[N][2];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            title[i][0] = input[0];
            title[i][1] = input[1];

        }

        int[] power = new int[M];
        for(int i = 0; i < M; i++) power[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {

            int start = 0;
            int end = title.length-1;
            int mid = (start+end)/2;
            while(start <= end) {
                mid = (start+end)/2;
                
                int value = Integer.parseInt(title[mid][1]);
                if(value < power[i]) {
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }

            sb.append(title[mid][0]).append("\n");

        }

        System.out.println(sb);

    }
}

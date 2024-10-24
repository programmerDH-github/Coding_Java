import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            int[][] employee = new int[N][2];
            for(int j = 0; j < N; j++) {
                String[] score = br.readLine().split(" ");

                employee[j][0] = Integer.parseInt(score[0]);
                employee[j][1] = Integer.parseInt(score[1]);

            }
            
            Arrays.sort(employee, (o1,o2) -> {
                return o1[0] - o2[0];
            });
            
            int answer = 0;
            int min = N+1;
            for(int j = 0; j < N; j++) {
                if(min > employee[j][1]) {
                    min = employee[j][1];
                    answer++;
                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
import java.io.*;

public class Baek_Joon_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        String[] numbers = br.readLine().split(" ");
        int[] sum = new int[N];
        for(int i = 0; i < N; i++) {
            if(i == 0) sum[i] = Integer.parseInt(numbers[i]);
            else sum[i] = sum[i-1] + Integer.parseInt(numbers[i]);
        }

        for(int i = 0; i < M; i++) {
            String[] start_end = br.readLine().split(" ");
            int start = Integer.parseInt(start_end[0]);
            int end = Integer.parseInt(start_end[1]);
            if(start == 1) {
                sb.append(sum[end-1]).append("\n");
            }
            else if(start == end) {
                sb.append(numbers[start-1]).append("\n");
            } 
            else {
                sb.append(sum[end-1]-sum[start-2]).append("\n");
            }
                
        }
        System.out.println(sb);
    }
}

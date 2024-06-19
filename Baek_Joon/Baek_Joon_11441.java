import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        String[] number = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(number[i]);
        }

        int[] sum = new int[N];
        for(int i = 0; i < N; i++) {
            if(i == 0) sum[i] = A[i];
            else sum[i] += sum[i-1] + A[i]; 
        }
 
        int M = Integer.parseInt(br.readLine());
        for(int z = 0; z < M; z++) {
            String[] i_j = br.readLine().split(" ");
            int i = Integer.parseInt(i_j[0]) - 1; 
            int j = Integer.parseInt(i_j[1]) - 1;
            
            if(i == 0) {
                sb.append(sum[j]).append("\n");
            }
            else {
                sb.append(sum[j]-sum[i]+A[i]).append("\n");
            }
        }

        System.out.println(sb);

    }
}

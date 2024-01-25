import java.io.*;

public class Baek_Joon_7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] person = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] w_h = br.readLine().split(" ");
            person[i][0] = Integer.parseInt(w_h[0]);
            person[i][1] = Integer.parseInt(w_h[1]);
        }

        int[] ranking = new int[N];
        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) rank++;
            }
            ranking[i] = rank;
        }

        for(int i = 0; i < ranking.length; i++) {
            System.out.print(ranking[i] + " ");
        }
    }
}

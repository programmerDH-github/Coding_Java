import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_X = br.readLine().split(" ");
        int N = Integer.parseInt(N_X[0]);
        int X = Integer.parseInt(N_X[1]);

        int[] days = new int[N+1];
        String[] day = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            days[i] = Integer.parseInt(day[i-1]);
        }

        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + days[i];
        }

        int max = 0;
        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(i+X-1 > N) break;
            int visit = dp[i+X-1] - dp[i-1];
            arraylist.add(visit);
            if(max < visit) max = visit;
        }
        
        Collections.sort(arraylist, Collections.reverseOrder());

        if(arraylist.get(0) == 0) System.out.println("SAD");
        else {
            int answer = arraylist.get(0);
            System.out.println(answer);
            int count = 0;
            for(int i = 0; i < arraylist.size(); i++) {
                if(answer == arraylist.get(i)) {
                    count++;
                }
            }    
            System.out.println(count);
        }

    }
}

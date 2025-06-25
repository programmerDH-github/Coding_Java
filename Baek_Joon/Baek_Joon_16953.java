import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16953 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");
        int A = Integer.parseInt(A_B[0]);
        int B = Integer.parseInt(A_B[1]);

        back(A,B,1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    static void back(long n, int target, int count) {
        if(target == n) {
            min = Math.min(min, count);
            return;
        }

        if(target < n) return;
        
        String num = Long.toString(n) + Integer.toString(1);
        back(n*2, target, count+1);
        back(Long.parseLong(num), target, count+1);

    }

}
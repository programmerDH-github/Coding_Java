import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baek_Joon_21919 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            if(prime(num)) set.add(num);
        }

        long answer = 1;
        if(set.isEmpty()) {
            System.out.println(-1);
        }
        else {
            for(int num : set) {
                answer *= num;
            }
            System.out.println(answer);
        }        
        
    }

    static boolean prime(int n) {        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}

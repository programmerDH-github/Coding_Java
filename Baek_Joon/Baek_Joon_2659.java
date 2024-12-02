import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int target = getClock(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
        
        boolean[] check = new boolean[10000];
        
        for(int i = 1111; i <= target; i++) {
            int a = i / 1000;
            int b = i % 1000 / 100;
            int c = i % 100 / 10;
            int d = i % 10;
            
            if(a == 0 || b == 0 || c ==0 || d == 0) continue;

            int min = getClock(a, b, c, d);
            check[min] = true;
        }

        int answer = 0;
        for(int i = 1111; i <= target; i++) if(check[i]) answer++;

        System.out.println(answer);

    }

    static int getClock(int a, int b, int c, int d) {
        int min = Integer.MAX_VALUE;

        min = Math.min(a*1000 + b*100 + c*10 + d , min);
        min = Math.min(b*1000 + c*100 + d*10 + a , min);
        min = Math.min(c*1000 + d*100 + a*10 + b , min);
        min = Math.min(d*1000 + a*100 + b*10 + c , min);

        return min;
    }

}

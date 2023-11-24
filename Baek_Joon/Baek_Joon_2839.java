import java.util.*;
import java.io.*;

public class Baek_Joon_2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while(true) {
            if(n % 5 == 0) {
                answer += n / 5;
                System.out.println(answer);
                break;
            }
            else if(n < 0) {
                System.out.println(-1);
                break;
            }
            n = n - 3;
            answer++;
        }        
    }
}

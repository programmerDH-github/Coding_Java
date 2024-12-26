import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1107 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[] broken = new boolean[10];
        int answer = Math.abs(100-N);

        // if(M == 0) {
        //     System.out.println(String.valueOf(N).length());
        //     return;
        // }

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            broken[Integer.parseInt(input[i])] = true;
        }

        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean check = true;
            for(int j = 0; j < str.length(); j++) {
                if(broken[str.charAt(j)-'0']) {
                    check = false;
                    break;
                }
            }

            if(check) {
                int count = str.length() + Math.abs(N-i);
                
                answer = Math.min(answer, count);
            } 

        }

        System.out.println(answer);

    }
}
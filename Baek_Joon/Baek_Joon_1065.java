import java.io.*;

public class Baek_Joon_1065 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        if(N < 100) {
            answer = N;
        }
        else {
            answer = 99;
            
            for(int i = 111; i <= N; i++) {
                if(i == 1000) break;                
                int distance = i%10 - (i/10)%10;
                if((i/10)%10 - (i/100)%10 == distance) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

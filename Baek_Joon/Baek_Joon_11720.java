import java.io.*;

/**
 * Baek_Joon_11720
 */
public class Baek_Joon_11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] number = br.readLine().split("");

        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer += Integer.parseInt(number[i]);
        }

        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Long,Long> map = new HashMap<>();
        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            map.put(Long.parseLong(numbers[i]),Long.parseLong(numbers[i]));
        }

        int M = Integer.parseInt(br.readLine());
        String[] number = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            if(map.containsKey(Long.parseLong(number[i]))) {
                sb.append(1);
            }
            else sb.append(0);
            sb.append("\n");
        }

        System.out.println(sb);
        
    }
}

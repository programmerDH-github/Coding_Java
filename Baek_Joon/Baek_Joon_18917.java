import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_18917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        int sum = 0;
        int xor = 0;
        for(int i = 0; i < M; i++) {
            String[] order = br.readLine().split(" ");
            
            if(order[0].equals("1")) {
                int number = Integer.parseInt(order[1]);
                sum += number;
                xor = xor ^ number;           
            }
            else if(order[0].equals("2")) {
                int number = Integer.parseInt(order[1]);
                sum -= number;
                xor = xor ^ number;
            }
            else if(order[0].equals("3")) sb.append(sum).append("\n");            
            else sb.append(xor).append("\n");  
        }
        
        System.out.println(sb);

    }
}

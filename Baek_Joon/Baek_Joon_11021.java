import java.io.*;

public class Baek_Joon_11021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String[] numbers = br.readLine().split(" ");
            int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            System.out.println("Case #"+(i+1)+": "+sum);
        }
    }
}

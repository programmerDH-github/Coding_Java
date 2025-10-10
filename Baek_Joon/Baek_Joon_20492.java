import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int first = (int)(N*0.78);
        int second = (int)(N*0.80 + N*0.2*0.78);
        
        System.out.println(first +" "+second);

    }
}

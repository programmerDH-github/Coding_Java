import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if((N - 1)%2 == 0 || (N - 3)%2 == 0) System.out.println("SK");
        else System.out.println("CY");
    }
}

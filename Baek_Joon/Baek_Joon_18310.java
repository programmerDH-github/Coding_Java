import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] antenna = new int[N];
        String[] home = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            antenna[i] = Integer.parseInt(home[i]);
        }

        Arrays.sort(antenna);

        if(N % 2 == 0) System.out.println(antenna[N/2-1]);
        else System.out.println(antenna[N/2]);
               

    }
}


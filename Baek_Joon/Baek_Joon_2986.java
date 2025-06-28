import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2986 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(readln());
        
    }

    static int readln() {
        int counter = 0;

        for(int i = N-1; i >= 1; i--) {
            counter += 1;
            if(N % i == 0) break;
        }
        return counter;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        ArrayList<Integer> arraylist = new ArrayList<>();

        String[] number = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arraylist.add(Integer.parseInt(number[i]));
        }

        number = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            arraylist.add(Integer.parseInt(number[i]));
        }

        Collections.sort(arraylist);        
        
        for(int num : arraylist) sb.append(num).append(" ");
        System.out.println(sb);

    }
}

import java.io.*;
import java.util.*;

public class Baek_Joon_14425 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" "); 
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < N; i++) {
            map.put(br.readLine(),0);
        }

        for(int i = 0; i < M; i++) {
            if(map.containsKey(br.readLine())) count++;
        }

        System.out.println(count);
    }
}

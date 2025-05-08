import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_K_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_K_M[0]);
        int K = Integer.parseInt(N_K_M[1]);
        int M = Integer.parseInt(N_K_M[2]);

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            arraylist.add(i);
        }
        
        int order = 0;
        int count = 0;
        boolean direction = true;
        while(!arraylist.isEmpty()) {
            if(count != 0 && count%M == 0) direction = !direction;

            if(direction) {
                order += K-1;
            }
            else {
                order -= K;
            }
            

            if(order == 0) {
                order = arraylist.size();
            }

            if(order < 0) {
                while (order < 0) {
                    order += arraylist.size();
                }
                
            }

            if(order >= arraylist.size()) {
                order %= arraylist.size();
            }
            count++;

            sb.append(arraylist.get(order)).append("\n");
            arraylist.remove(order);

        }

        System.out.println(sb);

    }
}

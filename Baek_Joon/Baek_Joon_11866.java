import java.io.*;
import java.util.*;

public class Baek_Joon_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arraylist.add(i+1);
        }

        int index = 0;
        int count = 0;
        sb.append("<");
        while(!arraylist.isEmpty()) {
            if(count == K) {
                index += count-1;
                if(index >= arraylist.size()) {
                    index = index % arraylist.size();
                }

                if(arraylist.size() == 1) {
                    sb.append(arraylist.get(index)).append(">");
                    arraylist.remove(index);
                }
                else {
                    sb.append(arraylist.get(index)).append(", ");
                    arraylist.remove(index);
                }
                
                if(count == 0) count = arraylist.size() - 1;
                else count = count - 1;

                count = 0;
            }

            count++;
        }

        System.out.println(sb);

    }
}

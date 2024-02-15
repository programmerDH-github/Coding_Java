import java.io.*;
import java.util.LinkedList;

public class Baek_Joon_1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);
        
        LinkedList<Integer> arraylist = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            arraylist.add(i+1);
        }

        sb.append("<");
        while(arraylist.size() > 1) {
            for(int i = 0; i < K-1; i++) {
                arraylist.add(arraylist.remove(0));
            }
            sb.append(arraylist.remove(0)).append(", ");
        }
        sb.append(arraylist.remove(0)).append(">");
        System.out.println(sb);
    }
}

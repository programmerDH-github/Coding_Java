import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_12873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            arraylist.add(i);
        }

        int t = 1;
        int idx = 0;
        while(arraylist.size() > 1) {
            long count = (long)Math.pow(t, 3);

            idx = (int)((idx+count-1) % arraylist.size());
            
            arraylist.remove(idx);
            t++;
        }

        System.out.println(arraylist.get(0));

    }
}

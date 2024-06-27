import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class Baek_Joon_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] number = br.readLine().split(" ");
        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!arraylist.contains(Integer.parseInt(number[i]))) arraylist.add(Integer.parseInt(number[i]));
        }

        Collections.sort(arraylist);

        System.out.println(arraylist);
        
    }
}

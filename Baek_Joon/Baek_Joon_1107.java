import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_1107 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arraylist = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            arraylist.add(Integer.parseInt(input[i]));
        }

        System.out.println(arraylist);
        System.out.println();
    }
}
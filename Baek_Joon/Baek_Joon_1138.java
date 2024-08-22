import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tall = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            tall[i] = Integer.parseInt(input[i]);
        }

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = N-1; i >= 0; i--) {
            arraylist.add(tall[i], i+1);
        }

        

        for(int answer : arraylist) System.out.print(answer +" ");

    }
}

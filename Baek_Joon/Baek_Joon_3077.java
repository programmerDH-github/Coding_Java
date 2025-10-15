import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baek_Joon_3077 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        HashMap<String,Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            map.put(input[i], i);
        }

        int a = 0;
        int b = N*(N-1)/2;

        for(int i = 0; i < N; i++) {
            int left = map.get(arr[i]);
            for(int j = i+1; j < N; j++) {
                int right = map.get(arr[j]);
                if(left < right) a++;
            }
        }

        System.out.println(a+"/"+b);

    }
}

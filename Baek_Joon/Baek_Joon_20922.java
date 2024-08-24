import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[] element = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            element[i] = Integer.parseInt(input[i]);
        }

        int[] elementCount = new int[100001];
        

        int i = 0;
        int j = 0;
        int count = 0;
        int maxlength = 0;
        while(j < N && i < N) {
            int value = element[j];
            if(elementCount[value] == K) {
                if(maxlength < count) maxlength = count;
                elementCount[element[i]]--;
                count--;
                i++;                
            }
            else {
                elementCount[value]++;
                count++;
                j++;
            }

        }

        if(maxlength < count) maxlength = count;

        System.out.println(maxlength);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6236 {
    static int[] arr; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int start = 0;
        int end = 0;
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end += arr[i];
            start = Math.max(start,arr[i]);
        }

        int answer = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            
            if(M >= getMid(mid)) {
                answer = mid;
                end = mid - 1;
                
            }
            else {
                start = mid + 1;
            }

        }

        System.out.println(answer);

    }

    static int getMid(int temp) {
        int count = 1;
        int money = temp;

        for(int num : arr) {
            money -= num;

            if(money < 0) {
                money = temp -num;
                count++;
            }
        }

        return count;

    }
}

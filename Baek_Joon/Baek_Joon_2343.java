import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2343 {
    static int N,M;
    static int[] lecture;
    static int left,right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        lecture = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(input[i]);
            left = Math.max(left, lecture[i]);
            right += lecture[i];
        }

        while(left <= right) {
            int mid = (left+right)/2;

            if(getCount(mid) > M) left = mid + 1;
            else right = mid - 1;

        }

        System.out.println(left);

    }

    static int getCount(int mid) {
        int count = 0;
        int sum = 0;
        
        for(int i = 0; i < N; i++) {
            if(sum + lecture[i] > mid) {
                count++;
                sum = 0;
            }
            sum += lecture[i];
        }
        
        return count;
    }
}
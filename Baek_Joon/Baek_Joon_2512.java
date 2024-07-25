import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2512 {
    static int N, M;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(input[i]);
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(cost);
        int[] max_cost = new int[2];
        for(int i = 1; i <= cost[cost.length-1]; i++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                if(i > cost[j]) {
                    sum += cost[j];
                }
                else {
                    sum += i;
                }
            }

            if(sum > M) break;
            if(max_cost[0] < sum) {
                max_cost[0] = sum;
                max_cost[1] = i;
            }
        }

        System.out.println(binarySearch(0, cost[cost.length-1]));
        
    }

    static int binarySearch(int start, int end) {
        while(start <= end) {
            int mid = (start + end)/2;
            int budget = 0;
            for(int i = 0; i < N; i++) {
                if(cost[i] > mid) budget += mid;
                else budget += cost[i];
            }

            if(budget <= M) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

}

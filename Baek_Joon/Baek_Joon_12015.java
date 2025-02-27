import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(input[i]);

        ArrayList<Integer> arraylist = new ArrayList<>();
        arraylist.add(A[0]);
        for(int i = 1; i < N; i++) {
            int target = A[i];
            if(arraylist.get(arraylist.size()-1) < target) arraylist.add(target);
            else {                
                int left = 0;
                int right = arraylist.size()-1;

                while(left < right) {
                    int mid = (left+right) / 2;
                    if(arraylist.get(mid) >= target) right = mid;
                    else left = mid + 1;
                }
                arraylist.set(right, target);
            }
        }

        System.out.println(arraylist.size());

    }
}

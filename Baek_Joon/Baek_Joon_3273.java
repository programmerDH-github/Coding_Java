import java.io.*;
import java.util.Arrays;

public class Baek_Joon_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        String[] a = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {            
            arr[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = n-1;
        while(start < end) {
            int sum = arr[start] + arr[end];
            
            if(sum == x) {
                count++;
                start++;
                end--;
            }
            else if(sum > x) {
                end--;
            }
            else {
                start++;
            }
        }

        System.out.println(count);
    }
}

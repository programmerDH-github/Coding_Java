import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10972 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        if(next_Permutation(arr)) {
            for(int num : arr) {
                sb.append(num).append(" ");
            }
        }
        else {
            sb.append("-1");
        }

        System.out.println(sb);
        
    }

    static boolean next_Permutation(int arr[]) {
        int i = arr.length - 1;

        while(i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }
        
        if(i <= 0) return false;

        int j = arr.length - 1;

        while(arr[i-1] >= arr[j]) {
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
        return true;
    }

}

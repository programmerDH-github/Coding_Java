import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_24060 {
    static int[] temp;
    static int N,K,result;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        N = Integer.parseInt(N_K[0]);
        K = Integer.parseInt(N_K[1]);

        int arr[] = new int[N];
        temp = new int[N+1];
        String[] number = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(number[i]);
        }
       
        merge_sort(arr,0,arr.length-1);

        if(result == 0) System.out.println(-1);
        else System.out.println(result);

    }
    static void merge_sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;       
            merge_sort(arr, start, mid);
            merge_sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 1;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }
            else {
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid) temp[t++] = arr[i++];
        while(j <= end) temp[t++] = arr[j++];
        
        i = start; t = 1;
        while(i <= end) {
            count++;

            if(count == K) {
                result = temp[t];
                break;
            }

            arr[i++] = temp[t++];
        }

    }
}

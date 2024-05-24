import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_10973 {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nums = new int[N];
        String[] number = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(number[i]);
        }

        if(pre_permutation()) {
            for(int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
        }
        else System.out.println("-1");



    }
    static boolean pre_permutation() {
        int i = nums.length - 1;
        while(i > 0 && nums[i-1] <= nums[i]) i--;

        if(i <= 0) return false;

        int j = nums.length - 1;
        while(nums[j] >= nums[i-1]) j--;
        
        swap(i-1, j);

        j = nums.length - 1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

}

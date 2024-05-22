import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] X_Y = br.readLine().split(" ");
        long X = Long.parseLong(X_Y[0]);
        long Y = Long.parseLong(X_Y[1]);

        int Z = (int)((Y*100) / X);

        if(Z == 99 || Z == 100) {
            System.out.println(-1);
            return;
        }

        int start = 0;
        int end = 1000000000;
        int result = -1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int tmp_z = (int)(((Y + mid)*100) / (X + mid));

            if(Z >= tmp_z) {
                result = mid + 1;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
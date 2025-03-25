import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 토핑 종류 수
        String[] A_B = br.readLine().split(" ");
        int A = Integer.parseInt(A_B[0]);           // 도우 가격
        int B = Integer.parseInt(A_B[1]);           // 토핑 가격
        int C = Integer.parseInt(br.readLine());    // 도우 열량

        // 토핑 열량
        Integer[] D = new Integer[N];
        for(int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순
        Arrays.sort(D, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int max = C / A;
        int DSum = 0;
        for(int i = 0; i < N; i++) {
            DSum += D[i];
            int cal = (C + DSum) / (A+B*(i+1));
            if(max > cal) break;
            max = cal;
        }

        System.out.println(max);

    }
}

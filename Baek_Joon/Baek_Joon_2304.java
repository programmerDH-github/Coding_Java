import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] stick = new int[N][2];
        int maxHeight = 0;
        
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            stick[i][0] = Integer.parseInt(input[0]);
            stick[i][1] = Integer.parseInt(input[1]);

            if(maxHeight < stick[i][1]) {
                maxHeight = stick[i][0];
                maxHeight = stick[i][1];
            }
        }

        Arrays.sort(stick, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // Arrays.sort(stick, (o1, o2) -> {
        //     return o1[0] - o2[0];
        // });

        int extent = ((stick[stick.length-1][0]+1) - stick[0][0]) * maxHeight;
        int removeExtent = 0;

        int leftLoaction = stick[0][0];
        int leftHeight = stick[0][1];
        for(int i = 1; i < N; i++) {
            if(stick[i][1] == maxHeight) {
                removeExtent += (stick[i][0] - leftLoaction) * (maxHeight - leftHeight);
                break;
            }

            if(stick[i][1] > leftHeight) {
                removeExtent += (stick[i][0]-leftLoaction) * (maxHeight - leftHeight);
                leftLoaction = stick[i][0];
                leftHeight = stick[i][1];
            }
        }

        int rightLoaction = stick[N-1][0];
        int rightHeight = stick[N-1][1];
        for(int i = N-2; i >= 0; i--) {
            if(stick[i][1] == maxHeight) {
                removeExtent += (rightLoaction - stick[i][0]) * (maxHeight - rightHeight);
                break;
            }

            if(stick[i][1] > rightHeight) {
                removeExtent += (rightLoaction - stick[i][0]) * (maxHeight - rightHeight);
                rightLoaction = stick[i][0];
                rightHeight = stick[i][1];
            }
        }


        System.out.println(extent-removeExtent);

    }
}

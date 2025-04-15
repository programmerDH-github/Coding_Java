import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Baek_Joon_15975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> arraylist = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arraylist.add(new int[]{x,y});
        }

        Collections.sort(arraylist, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        long answer = 0;
        for(int i = 0; i < arraylist.size(); i++) {
            int left = i-1;
            int right = i+1;
            int value = Integer.MAX_VALUE;

            if(left >= 0 && arraylist.get(left)[1] == arraylist.get(i)[1]) {
                value = Math.min(value, Math.abs(arraylist.get(left)[0] - arraylist.get(i)[0]));
            }
            if(right < arraylist.size() && arraylist.get(right)[1] == arraylist.get(i)[1]) {
                value = Math.min(value, Math.abs(arraylist.get(right)[0] - arraylist.get(i)[0]));
            }

            answer += value != Integer.MAX_VALUE ? value : 0;

        }

        System.out.println(answer);

    }
}

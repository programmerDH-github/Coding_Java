import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_1485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            int[][] coordinate = new int[4][2];

            for(int j = 0; j < 4; j++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                coordinate[j][0] = x;
                coordinate[j][1] = y;                

            }

            ArrayList<Double> arraylist = new ArrayList<>();
            for(int j = 0; j < 4; j++) {
                for(int k = j+1; k < 4; k++) {
                    arraylist.add(distance(coordinate[j][0], coordinate[j][1], coordinate[k][0], coordinate[k][1]));
                }
            }
            
            Collections.sort(arraylist);

            boolean check = true;
            for(int j = 1; j < 4; j++) {
                if(Double.compare(arraylist.get(0), arraylist.get(j)) != 0) {
                    check = false;
                }
            }
            
            if(Double.compare(arraylist.get(4), arraylist.get(5)) != 0) {
                check = false;
            }
            
            if(check) sb.append(1).append("\n");
            else sb.append(0).append("\n");

        }

        System.out.println(sb);

    }

    static double distance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2));
    }

}

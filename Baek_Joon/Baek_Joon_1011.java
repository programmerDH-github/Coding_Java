package Baek_Joon;

import java.io.*;

public class Baek_Joon_1011 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] x_y = br.readLine().split(" ");
            long x = Long.parseLong(x_y[0]);
            long y = Long.parseLong(x_y[1]);

            long distance = y - x;
            long move = 1;
            long count = 0;
            long moveSum = 0;

            while (moveSum < distance) {
                count++;
                moveSum += move;
                if (count % 2 == 0) {
                    move++;
                }
            }

            System.out.println(count);
        }
    }

}

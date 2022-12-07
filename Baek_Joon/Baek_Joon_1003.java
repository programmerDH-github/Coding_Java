package Baek_Joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			int[][] fibonacci = new int[41][2];
			fibonacci[0][0] = 1;
			fibonacci[0][1] = 0;
			fibonacci[1][0] = 0;
			fibonacci[1][1] = 1;

			for (int k = 2; k <= N; k++) {
				fibonacci[k][0] = fibonacci[k - 1][0] + fibonacci[k - 2][0];
				fibonacci[k][1] = fibonacci[k - 1][1] + fibonacci[k - 2][1];

			}
			System.out.println(fibonacci[N][0] + " " + fibonacci[N][1]);
		}

	}

}

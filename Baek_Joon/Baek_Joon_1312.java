package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_1312 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		int N = Integer.parseInt(str[2]);
		
		int answer = A%B;
		
		for(int i = 0; i < N; i++) {
			answer *= 10;
			if(i == N-1) {
				System.out.println(answer/B);
				break;
			}
			answer %= B; 
		}
		
	}

}
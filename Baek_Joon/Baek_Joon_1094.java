package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_1094 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int standard = 64;
		int X = Integer.parseInt(br.readLine());
		int answer = 0;
		
		while(X > 0) {
			if(X >= standard) {
				answer++;
				X -= standard;
			}
			else {
				standard /= 2;
			}
		}
		
		System.out.println(answer);
		
	}	
	
}
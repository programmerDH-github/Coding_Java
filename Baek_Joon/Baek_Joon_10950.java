package Baek_Joon;

import java.io.*;

public class Baek_Joon_10950 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] numbers = br.readLine().split(" ");
			System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
		}
	}

}

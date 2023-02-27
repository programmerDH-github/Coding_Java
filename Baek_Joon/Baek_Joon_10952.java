package Baek_Joon;

import java.io.*;

public class Baek_Joon_10952 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] numbers = br.readLine().split(" ");
			
			if("0".equals(numbers[0]) && "0".equals(numbers[1])) break;
			
			System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
		}
		
	}
}

package Baek_Joon;

import java.io.*;

public class Baek_Joon_15964 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = br.readLine().split(" ");
		long A = Long.parseLong(numbers[0]);
		long B = Long.parseLong(numbers[1]);
		
		System.out.println((A+B)*(A-B));
	}

}

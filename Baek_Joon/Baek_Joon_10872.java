package Baek_Joon;

import java.io.*;

public class Baek_Joon_10872 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 1;
		
		for(int i = 1; i <= N; i++) answer *= i;		
		System.out.println(answer);
	}
}

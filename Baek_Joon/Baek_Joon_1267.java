package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_1267 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] fees = new int[2];
		String[] call_fee = br.readLine().split(" ");
		int Y = 0;
		int M = 0;		
		
		for(int i = 0; i < N; i++) {
			
			// ¿µ½Ä Y
			int fee_Y = Integer.parseInt(call_fee[i]);
			while(true) {
				if(fee_Y / 39 > 0) {
					fees[0] += fee_Y/30*10;
					fee_Y = fee_Y%30;
				}
				else {
					fees[0] += 10;
					break;
				}
			}			
			// ¹Î½Ä M
			int fee_M = Integer.parseInt(call_fee[i]);
			while(true) {
				if(fee_M / 60 > 0) {
					fees[1] += fee_M/60*15;
					fee_M = fee_Y%60;
				}
				else {
					fees[1] += 15;
					break;
				}
				
			}
		}
		
		if(fees[0] == fees[1]) System.out.println("Y M "+ fees[0]);
		else if(fees[0] > fees[1]) System.out.println("M "+ fees[1]);
		else System.out.println("Y "+ fees[0]);
		
		
	}			
}
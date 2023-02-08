package Baek_Joon;

import java.io.*;

public class Baek_Joon_1193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int X = Integer.parseInt(br.readLine());
		
		int idx = 1;
		int start = 1;
		boolean flag = true;
		while(true) {
			for(int i = start; i < start+idx; i++) {
				if(i == X) {
					flag = false;
					break;
				}
			}
			
			if(!flag) break;
			
			start += idx;
			idx++;
		}
		
		if(idx % 2 == 0) {
			for(int i = 0; i < idx; i++) {
				if(start+i == X) System.out.println((i+1)+"/"+(idx-i));
			}
		}
		else {
			for(int i = 0; i < idx; i++) {
				if(start+i == X) System.out.println((idx-i)+"/"+(i+1));
			}
		}
		
	}

}

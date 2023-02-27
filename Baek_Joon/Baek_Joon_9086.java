package Baek_Joon;

import java.io.*;

public class Baek_Joon_9086 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String str = br.readLine();
			
			if(str.length() == 1) System.out.println(str+""+str);
			else {
				System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
			}
		}
	}

}

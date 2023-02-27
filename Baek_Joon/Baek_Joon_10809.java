package Baek_Joon;

import java.io.*;
import java.util.*;

public class Baek_Joon_10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int[] alphabet = new int[26];
		
		Arrays.fill(alphabet, -1);
		
		for(int i = 0; i < S.length(); i++) {
			int idx = (int)S.charAt(i) - 97;
			if(alphabet[idx] == -1) {
				alphabet[idx] = i;
			}
		}
		
		for(int alph : alphabet) System.out.print(alph +" ");
	}
}

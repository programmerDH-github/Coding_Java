package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_Joon_10804 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cards = new int[20];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = i+1;
		}
		
		for(int i = 0; i < 10; i++) {
			String[] loaction = br.readLine().split(" ");
			
			int first_index = Integer.parseInt(loaction[0])-1;
			int last_index = Integer.parseInt(loaction[1])-1;
			while(first_index < last_index) {
				int temp = cards[first_index];
				cards[first_index] = cards[last_index];
				cards[last_index] = temp;
				first_index++; last_index--;
			}
		}
		
		for(int card : cards) System.out.print(card +" ");		
		
	}
}

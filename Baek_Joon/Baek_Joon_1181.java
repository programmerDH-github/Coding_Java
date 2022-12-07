package Baek_Joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_1181 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arraylist = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			
			if(!arraylist.contains(word)) {
				arraylist.add(word);				
			}
		}
		
		arraylist.sort((s1,s2) -> {
			if(s1.length() > s2.length()) return 1;
			else if(s1.length() < s2.length()) return -1;
			else return s1.compareTo(s2);
		});
		
		for(int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
	
		
	}	
	
}

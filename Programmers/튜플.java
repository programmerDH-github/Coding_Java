package Programmers;

import java.util.*;

public class Æ©ÇÃ {

	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		ArrayList<String> arraylist = new ArrayList<>();
		s = s.substring(0,s.length()-1) + ",";
		s = s.replaceAll("\\{", "");
		
		String[] arr_s = s.split("},");
		
		Arrays.sort(arr_s, (String s1, String s2) -> s1.length() - s2.length());
		
		for(int i = 0; i < arr_s.length; i++) {
			String[] number = arr_s[i].split(",");
			
			for(int j = 0; j < number.length; j++) {
				if(!arraylist.contains(number[j])) arraylist.add(number[j]);
			}
			
		}
		
		int[] answer = new int[arraylist.size()];
		for(int i = 0; i < arraylist.size(); i++) {
			answer[i] = Integer.parseInt(arraylist.get(i));
			System.out.print(answer[i] +" ");
		}
		

	}

}

package Programmers;

import java.util.*;

public class 할인_행사 {

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", 
				"apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		int answer = 0;
		
		for(int i = 0; i < discount.length; i++) {
			ArrayList<String> arraylist = new ArrayList<>();
			int sum = arraylist.size();
			
			for(int j = 0; j < number.length; j++) {
				for(int k = 0; k < number[j]; k++) {					
					arraylist.add(want[j]);
				}
			}
			if(discount.length-i >= 10) {
				for(int j = i; j < 10+i; j++) {
					arraylist.remove(discount[j]);
				}
				if(arraylist.size() == 0) answer++;
			}
			else if(discount.length-i < sum) {
				break;
			}
			else {
				for(int j = i; j < discount.length; j++) {
					arraylist.remove(discount[j]);
				}
				if(arraylist.size() == 0) answer++;
			}
		}
		
		System.out.println(answer);
	}

}

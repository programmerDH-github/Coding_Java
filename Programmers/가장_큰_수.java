package Programmers;

import java.util.*;

public class 가장_큰_수 {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		
		String[] numbers_string = new String[numbers.length];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers_string[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(numbers_string, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);
			}
		});
		
		String answer = "";
		for(String str : numbers_string) answer += str;
		
		System.out.println(answer.charAt(0) == 0 ? "0" : answer);

	}

}

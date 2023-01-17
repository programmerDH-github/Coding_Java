package Programmers;

import java.util.*;

public class 연속부분수열_합의_개수 {
	
	static ArrayList<Integer> arraylist = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] elements = {7,9,1,1,4};
		int[] new_elements = new int[elements.length*2];
		
		for(int i = 0; i < elements.length; i++) {
			new_elements[i] = elements[i];
			new_elements[i+elements.length] = elements[i];
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= elements.length; i++) {
			for(int j = 0; j < elements.length; j++) {
				set.add(Arrays.stream(new_elements,j,j+i).sum());
			}
		}
		
		int answer = set.size();
		System.out.println(answer);
		
	}
}

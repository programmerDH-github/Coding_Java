package Programmers;

import java.util.*;

public class «¡∏∞≈Õ {

	public static void main(String[] args) {
		int[] priorities = {2,3,3,2,9,3,3};
		int location = 3;
		int answer = 1;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
		}
		
		while(!queue.isEmpty()) {
			for(int i = 0; i < priorities.length; i++) {
				if(queue.peek() == priorities[i]) {
					if(i == location) {
						System.out.println(answer);
						return;
					}
					answer++;
					queue.poll();
				}
			}
		}
		
		
		System.out.println(answer);

	}

}

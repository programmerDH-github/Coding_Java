package Baek_Joon;
import java.util.*;
import java.io.*;

public class Baek_Joon_1715 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			queue.add(number);
		}
		
		while(queue.size() > 1) {
			System.out.println(queue);
			int first = queue.poll();
			int second = queue.poll();
			
			answer += first+second;
			queue.add(first + second);
		}
		
		System.out.println(answer);

	}

}

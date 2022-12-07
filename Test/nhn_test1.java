package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class nhn_test1 {

	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int n = 4;
		int k = 3;
		int answer = 0;
		int[][] arr = {{6, 18, 16, 17, 2, 9, 19},{8, 2, 16, 3, 11, 6, 19, 15, 17},
				{5, 19, 1, 4, 17, 7},{6, 16, 3, 6, 19, 14, 12}};
				
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length; j++) {
				if(!map.containsKey(arr[i][j])) {
					map.put(arr[i][j], 1);
				}
				else {
					map.put(arr[i][j], map.get(arr[i][j])+1);
				}
			}
		}
		
		// map.values() 메소드를 통하여 map의 모든 값을 Collection 객체로 받음
		Collection<Integer> values = map.values();
		// Collection 객체를 ArrayList에 저장
		ArrayList<Integer> arraylist = new ArrayList<>(values);
		
		// 정렬
		Collections.sort(arraylist);
		// 내림차순 정렬 시
		// Collections.sort(arraylist, Collections.reverseOrder());
		
		for(int i = arraylist.size()-1; i >= arraylist.size() - k; i--) {
			System.out.println(arraylist.get(i));
			answer += arraylist.get(i);
		}
		
		System.out.println(answer);
		
	}

}

/* 예제 1
	4 3
	{6, 18, 16, 17, 2, 9, 19},{8, 2, 16, 3, 11, 6, 19, 15, 17},
	{5, 19, 1, 4, 17, 7},{6, 16, 3, 6, 19, 14, 12}
				
	10
*/
/* 	예제 2
	6 4
	{6, 1, 5, 3, 11, 9, 6},{8, 1, 16, 14, 18, 13, 19, 7, 10}, {8, 10, 14, 3, 12, 7, 11, 8, 13},
	{6, 17, 1, 5, 16, 6, 20}, {10, 17, 12, 15, 20, 9, 5, 16, 18, 10, 14}, {7, 6, 3, 1, 20, 9, 2, 18}
			
	13
*/
/* 예제 3
	5 3
	{9, 19, 15, 3, 11, 10, 18, 4, 14, 12},{7, 20, 19, 11, 3, 9, 18, 8}, {6, 12, 16, 11, 19, 14, 2},
	{10, 1, 10, 4, 3, 8, 20, 18, 12, 14, 13}, {8, 14, 15, 10, 2, 9, 5, 16, 13}
			
	10
*/

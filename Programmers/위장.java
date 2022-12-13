package Programmers;

import java.util.*;

public class ¿ß¿Â {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}
		,{"green_turban", "headgear"}};
		int answer = 1;
		
		Map<String, Integer> map = new HashMap<>();

		for(int i = 0; i < clothes.length; i++) {
			if(!map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], 2);
			}
			else {
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
			}
		}
		
		for(String key : map.keySet()) {
			answer *= map.get(key);
		}
		
		System.out.println(answer-1);
	}

}

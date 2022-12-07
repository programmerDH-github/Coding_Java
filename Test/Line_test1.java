package Test;

import java.util.HashMap;

public class Line_test1 {
	static int squared = 2;
	public static void main(String[] args) {
		int[][] queries = {{1,1},{1,2},{1,4},{1,8}};
		int answer = 0;
        
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> minSquared = new HashMap<>();

        for(int i = 0; i < queries.length; i++) {
            if(!map.containsKey(queries[i][0])) {
            	map.put(queries[i][0], queries[i][1]);
            	
            	while(queries[i][1] > squared) {
            		squared = squared * 2;
            	}
            	minSquared.put(queries[i][0], squared);
            	squared = 2;
            }
            else {
            	if(map.get(queries[i][0]) + queries[i][1] > minSquared.get(queries[i][0])) {
            		answer += map.get(queries[i][0]);
            		map.put(queries[i][0], map.get(queries[i][0])+queries[i][1]);
            		
            		while(minSquared.get(queries[i][0]) > map.get(queries[i][0])+queries[i][1]) {
            			minSquared.put(queries[i][0], minSquared.get(queries[i][0])*2);
            		}
            	}
            	else {
            		map.put(queries[i][0], map.get(queries[i][0])+queries[i][1]);
            	}
            }
            
        }
        
        System.out.println(answer);

	}

}

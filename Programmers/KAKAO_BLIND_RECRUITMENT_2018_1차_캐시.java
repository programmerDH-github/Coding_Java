package Programmers;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_1Â÷Ä³½Ã {

	public static void main(String[] args){
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork"
				, "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		ArrayList<String> city_list = new ArrayList<>();
        int answer = 0;
        
        if(cacheSize == 0) System.out.println(cities.length * 5);
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(city_list.size() != cacheSize) {
                if(!city_list.contains(city)) {
                    city_list.add(0,city);
                    answer += 5;
                }
                else {
                    city_list.remove(city);
                    city_list.add(0,city);
                    answer += 1;
                }
                
            }
            else {
                if(!city_list.contains(city)) {
                    city_list.remove(city_list.size()-1);
                    city_list.add(0,city);
                    answer += 5;
                }
                else {
                    city_list.remove(city);
                    city_list.add(0,city);
                    answer += 1;
                }
            }
        }
        
        System.out.println(answer);

	}

}

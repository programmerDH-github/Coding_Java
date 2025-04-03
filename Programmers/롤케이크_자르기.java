package Programmers;

import java.util.HashMap;

public class 롤케이크_자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2}; // answer = 2
        // int[] topping = {1, 2, 3, 1, 4}; // answer = 0

        int answer = 0;
        
        if(topping.length == 1) {
            System.out.println(0);
            return;
        }
        
        HashMap<Integer, Integer> leftTopping = new HashMap<>();
        HashMap<Integer, Integer> rightTopping = new HashMap<>();
        
        leftTopping.put(topping[0],1);
        for(int i = 1; i < topping.length; i++) {
            if(!rightTopping.containsKey(topping[i])) rightTopping.put(topping[i],1);
            else rightTopping.put(topping[i],rightTopping.get(topping[i])+1);
        }
        
        if(leftTopping.size() == rightTopping.size()) answer++;
        
        for(int i = 1; i < topping.length; i++) {
            if(!leftTopping.containsKey(topping[i])) leftTopping.put(topping[i],1);
            else leftTopping.put(topping[i],leftTopping.get(topping[i])+1);
            
            if(rightTopping.get(topping[i]) == 1) rightTopping.remove(topping[i]);
            else rightTopping.put(topping[i], rightTopping.get(topping[i])-1); 
            
            if(leftTopping.size() == rightTopping.size()) answer++;            
        }

        System.out.println(answer);

    }
}

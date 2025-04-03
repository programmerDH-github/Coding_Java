package Programmers;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // answer = [0,0];
        // String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; // answer = [333,-45];

        int[] answer = new int[2];
        
        PriorityQueue<Integer> ascPq = new PriorityQueue<>();
        PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] order = operations[i].split(" ");
            int number = Integer.parseInt(order[1]);
            
            if(order[0].equals("I")) {
                ascPq.offer(number);
                descPq.offer(number);
            }
            else if(number == 1) {
                if(!ascPq.isEmpty()) ascPq.remove(descPq.poll());
                
            }
            else {
                if(!ascPq.isEmpty()) descPq.remove(ascPq.poll());
            }        
        }
        
        if(!ascPq.isEmpty()) {
            answer[0] = descPq.poll();
            answer[1] = ascPq.poll();
        }

        System.out.println(answer[0]+" "+answer[1]);

    }
}

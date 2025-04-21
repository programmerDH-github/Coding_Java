package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수 {
    public static void main(String[] args) {
        int[] works = {4, 3, 3};    // answer = 12
        int n = 4;
        // int[] works = {2, 1, 2}; // answer = 6
        // int n = 1;
        // int[] works = {1, 1};    // answer = 0
        // int n = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) pq.offer(works[i]);

        for(int i = 0; i < n; i++) {
            if(pq.isEmpty()) {
                System.out.println(0);
                return;
            }

            int number = pq.poll()-1;
            if(number != 0) pq.offer(number);
        }

        long answer = 0;
        while(!pq.isEmpty()) answer += Math.pow(pq.poll(), 2);

        System.out.println(answer);

    }
}

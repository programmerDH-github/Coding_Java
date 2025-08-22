package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 인사고과 {
    public static void main(String[] args) {
        // int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};   // rsult = 4
        int[][] scores = {{100,1},{100,2},{50,1}};

        int[] target = scores[0];

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });

        int temp = -1;
        int answer = 1;
        for(int i = 0; i < scores.length; i++) {
            if(scores[i][0] > target[0] && scores[i][1] > target[1]) {
                System.out.println(-1);
                break;
            }
            
            if(temp <= scores[i][1]) {                               
                if(scores[i][0]+scores[i][1] > target[0]+target[1]) answer++;
                temp = scores[i][1]; 
            }
        }
        
        System.out.println(answer);

    }
}

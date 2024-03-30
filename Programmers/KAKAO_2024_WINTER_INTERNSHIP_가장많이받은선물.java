package Programmers;

import java.util.Arrays;

public class KAKAO_2024_WINTER_INTERNSHIP_가장많이받은선물 {
    
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        
        int[][] relationship = new int[friends.length][friends.length];
        int[] frequency = new int[friends.length];
        for(int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            int nx = 0;
            int ny = 0;
            for(int j = 0; j < friends.length; j++) {
                if(gift[0].equals(friends[j])) {
                    nx = j;
                }
                if(gift[1].equals(friends[j])) {
                    ny = j;
                }
            }
            relationship[nx][ny] += 1;
        }

        
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                frequency[i] += relationship[i][j];
                frequency[i] -= relationship[j][i];
            }
        }

        int[] answer = new int[friends.length];
        for(int i = 0; i < friends.length; i++) {
            for(int j = i+1; j < friends.length; j++) {
                if(relationship[i][j] > relationship[j][i]) {
                    answer[i]++;
                }
                else if(relationship[i][j] < relationship[j][i]) {
                    answer[j]++;
                }
                else {
                    if(frequency[i] > frequency[j]) {
                        answer[i]++;
                    }
                    else if(frequency[i] < frequency[j]) {
                        answer[j]++;
                    }
                    else {
                        continue;
                    }
                }
            }
        }

        Arrays.sort(answer);
        System.err.println(answer[answer.length-1]);

    }    
}
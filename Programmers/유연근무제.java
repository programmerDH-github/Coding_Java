package Programmers;

public class 유연근무제 {
    public static void main(String[] args) {
        // int[] schedules = {700, 800, 1100};
        // int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        // int startday = 5;   // answer : 3

        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
        int startday = 1;   // answer : 2

        // startday 1:월, 2:화, 3:수, 4:목, 5:금, 6:토, 7:일

        int answer = 0;
        for(int i = 0; i < schedules.length; i++) {
            int schedule = (schedules[i] / 100) * 60 + (schedules[i] % 100);
            boolean success = true;
            
            for(int j = 0; j < timelogs[i].length; j++) {
                int timelog = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                if((startday+j)%7 > 0 && (startday+j)%7 < 6) {                    
                    if(timelog - schedule > 10) {
                        success = false;
                        break;
                    }
                }
            }

            if(success) answer++;            
            
        }

        System.out.println(answer);
        
    }
}

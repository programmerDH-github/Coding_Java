package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class KAKAO_BLIND_RECRUITMENT_2023_개인정보수집유효기간 {
    public static void main(String[] args) {
        // String today = "2022.05.19";
        // String[] terms = {"A 6", "B 12", "C 3"};
        // String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        ArrayList<Integer> arraylist = new ArrayList<>();
        String[] today_date = today.split("\\.");
        int today_as_date = Integer.parseInt(today_date[0])*12*28 + Integer.parseInt(today_date[1])*28 + Integer.parseInt(today_date[2]);

        for(int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");

            for(int j = 0; j < privacies.length; j++) {
                String[]  date_type = privacies[j].split(" ");
                String[] date = date_type[0].split("\\.");
                String type = date_type[1];

                if(term[0].equals(type)) {
                    System.err.println();
                    int date_as_day = Integer.parseInt(date[0])*12*28 + Integer.parseInt(date[1])*28 + Integer.parseInt(date[2]) 
                    + Integer.parseInt(term[1])*28;
                    if(date_as_day <= today_as_date) arraylist.add(j+1);
                    
                }                
                
            }
        }
        Collections.sort(arraylist);
        System.out.println(arraylist);
    }
}
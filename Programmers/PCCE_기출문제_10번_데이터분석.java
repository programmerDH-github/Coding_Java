package Programmers;

import java.util.*;

public class PCCE_기출문제_10번_데이터분석 {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        int ext_index, sort_by_index;
        if(ext.equals("code")) ext_index = 0;
        else if(ext.equals("date")) ext_index = 1;
        else if(ext.equals("maximum")) ext_index = 2;
        else ext_index = 3;

        if(sort_by.equals("code")) sort_by_index = 0;
        else if(sort_by.equals("date")) sort_by_index = 1;
        else if(sort_by.equals("maximum")) sort_by_index = 2;
        else sort_by_index = 3;

        ArrayList<int[]> arraylist = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][ext_index] < val_ext) {
                arraylist.add(new int[]{data[i][0], data[i][1], data[i][2], data[i][3]});
            }
        }

        Collections.sort(arraylist, (o1, o2) -> o1[sort_by_index] - o2[sort_by_index]);

        for(int i = 0; i < arraylist.size(); i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(arraylist.get(i)[j] + " ");
            }
            System.out.println();
        }

    }
}

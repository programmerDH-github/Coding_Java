package Softeer;

import java.util.*;
import java.io.*;

public class 변속기_8단 {

	static int[] asc = {1,2,3,4,5,6,7,8};
    static int[] des = {8,7,6,5,4,3,2,1};
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] gear = br.readLine().split(" ");

        int[] number = new int[gear.length];

        for(int i = 0; i < gear.length; i++) number[i] = Integer.parseInt(gear[i]);

        if(comp(number,asc)) System.out.println("ascending");
        else if(comp(number,des)) System.out.println("descending");
        else System.out.println("mixed");

    }

    static boolean comp(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) if(arr1[i] != arr2[i]) return false;
        return true;
    }

}

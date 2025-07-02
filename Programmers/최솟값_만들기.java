package Programmers;

import java.util.Arrays;

public class 최솟값_만들기 {
    public static void main(String[] args) {
        int []A = {1, 4, 2}; 
        int []B = {5, 4, 4};    // answer : 29
        // int []A = {1, 2}; 
        // int []B = {3, 4};    // answer : 10

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length-1-i];
        }

        System.out.println(answer);

    }
}

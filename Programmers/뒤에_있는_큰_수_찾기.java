package Programmers;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5}; // result = [3,5,5,-1];
        // int[] numbers = {9, 1, 5, 3, 6, 2}; // result = [-1, 5, 6, 6, -1, -1];

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);

        for(int i = 0; i < numbers.length; i++) {

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }


    }
}

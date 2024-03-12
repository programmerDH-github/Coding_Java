import java.io.*;
import java.util.ArrayList;

public class Baek_Joon_14888 {
    static ArrayList<String> arraylist;
    static boolean[] visited;
    static int[] numbers;
    static int[] max_min = {-1000000000, 1000000000};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] calculation_index = br.readLine().split(" ");

        numbers = new int[N];
        for(int i = 0; i < A.length; i++) {
            numbers[i] = Integer.parseInt(A[i]);
        }

        arraylist = new ArrayList<>();
        
        String[] calculation = {"+", "-", "*", "/"};
        for(int i = 0; i < 4; i++) {
            int index = Integer.parseInt(calculation_index[i]);
            if(index == 0) continue;
            else {
                for(int j = 0; j < index; j++) {
                    arraylist.add(calculation[i]);
                }
            }
        }
        visited = new boolean[arraylist.size()];

        dfs("");

        System.out.println(max_min[0]);
        System.out.println(max_min[1]);

    }

    public static void dfs(String str) {
        if(str.length() == arraylist.size()*2) {
            String[] cal = str.split(" ");
            int sum = 0;
            
            for(int i = 0; i < numbers.length; i++) {
                if(i == 0) {
                    sum = numbers[i];
                }
                else {
                    if(cal[i-1].equals("+")) {
                        sum += numbers[i];
                    }
                    else if(cal[i-1].equals("-")) {
                        sum -= numbers[i];
                    }
                    else if(cal[i-1].equals("*")) {
                        sum *= numbers[i];
                    }
                    else {
                        sum /= numbers[i];
                    }
                }
                
            }

            if(sum > max_min[0]) {
                max_min[0] = sum;
            }
            if(sum < max_min[1]) {
                max_min[1] = sum;
            }

            return;
        }
        for(int i = 0; i < arraylist.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(str + arraylist.get(i) + " ");
                visited[i] = false;
            }
            
            
        }
    }
}

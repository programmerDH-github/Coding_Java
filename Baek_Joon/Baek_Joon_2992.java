import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_2992 {
    static String[] X;
    static boolean[] visited;
    static ArrayList<Integer> arraylist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int target = Integer.parseInt(input);
        X = input.split("");
        visited = new boolean[X.length];
        
        arraylist = new ArrayList<>();
        for(int i = 0; i < X.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(X[i]);
                visited[i] = false;
            }
        }
        
        Collections.sort(arraylist);

        for(int i = 0; i < arraylist.size(); i++) {
            if(arraylist.get(i) == target) {
                if(i == arraylist.size()-1) System.out.println(0);
                else System.out.println(arraylist.get(i+1));
            }
        }

    }

    static void dfs(String str) {
        if(str.length() == X.length) {
            if(!arraylist.contains(Integer.parseInt(str))) arraylist.add(Integer.parseInt(str));
            return;
        }


        for(int i = 0; i < X.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(str+X[i]);
                visited[i] = false;
            }
        }
    }

}

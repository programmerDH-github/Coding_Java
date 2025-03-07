import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_9934 {
    static int k;
    static int[] order;
    static ArrayList<ArrayList<Integer>> arraylist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        order = new int[(int)Math.pow(2, k)-1];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < order.length; i++) {
            order[i] = Integer.parseInt(input[i]);
        }

        arraylist = new ArrayList<>();
        for(int i = 0; i < k; i++) arraylist.add(new ArrayList<>());

        dfs(0,order.length-1,0);

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < arraylist.get(i).size(); j++) {
                sb.append(arraylist.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }   

    static void dfs(int low, int high, int depth) {
        if(depth == k) return;

        int mid = (low+high)/2;
        
        arraylist.get(depth).add(order[mid]);

        dfs(low,mid-1,depth+1);
        dfs(mid+1,high,depth+1);

    }


}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_12101 {
    static int n,k,count;
    static ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_k = br.readLine().split(" ");
        
        n = Integer.parseInt(n_k[0]);
        k = Integer.parseInt(n_k[1]);

        dfs("",0);

        if(count < k) System.out.println(-1);

    }

    static void dfs(String str, int sum) {
        if(sum >= n) {
            if(sum == n) {
                count++;

                if(count == k) {
                    for(int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i));
                        
                        if(i != list.size()-1) System.out.print("+"); 
                    }
                }       
            }

            return;
        }

        for(int i = 1; i <= 3; i++) {
            list.add(i);
            dfs(str+i+" ", sum+i);
            list.remove(list.size()-1);
        }


    }
}

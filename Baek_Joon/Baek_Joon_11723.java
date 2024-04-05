import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Baek_Joon_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < M; i++) {
            String[] order = br.readLine().split(" ");

            int n = 0;
            if(order.length == 2) n = Integer.parseInt(order[1]);
            if(order[0].equals("add")) {
                set.add(n);
            }
            else if(order[0].equals("remove")) {
                set.remove(n);
            }
            else if(order[0].equals("check")) {
                if(set.contains(n)) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(order[0].equals("toggle")) {
                if(set.contains(n)) set.remove(n);
                else set.add(n);
            }
            else if(order[0].equals("all")) {
                for(int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }
            else {
                set.clear();
            }
        }

        System.out.println(sb);

    }
}

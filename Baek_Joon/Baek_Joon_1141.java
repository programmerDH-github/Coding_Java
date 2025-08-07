import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Baek_Joon_1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] X = new String[N];
        for(int i = 0; i < N; i++) {
            X[i] = br.readLine();
        }

        Arrays.sort(X, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < X.length; i++) {
            if(set.size() == 0) {
                set.add(X[i]);
                continue;
            }
            
            boolean check = false;
            for(String str : set) {
                if(str.indexOf(X[i]) == 0) {
                    check = true;
                    break;
                }
            }

            if(!check) {
                set.add(X[i]);
            }

        }

        System.out.println(set.size());
        
    }
}

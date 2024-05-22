import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_Joon_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] number = new String[N];
        for(int i = 0; i < N; i++) {
            number[i] = br.readLine();
        }

        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    String n_s1 = s1.replaceAll("[^0-9]", "");
                    String n_s2 = s2.replaceAll("[^0-9]", "");

                    int sum_s1 = 0;
                    int sum_s2 = 0;
                    for(int i = 0; i < n_s1.length(); i++) {
                        sum_s1 += n_s1.charAt(i) - '0';
                    }

                    for(int i = 0; i < n_s2.length(); i++) {
                        sum_s2 += n_s2.charAt(i) - '0';
                    }

                    if(sum_s1 == sum_s2) return s1.compareTo(s2);
                    
                    return sum_s1 - sum_s2;
                }
                return s1.length() - s2.length();
            }
        });

        for(int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }

    }
}

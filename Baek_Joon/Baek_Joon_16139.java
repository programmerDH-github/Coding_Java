import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] S = br.readLine().split("");
        int q = Integer.parseInt(br.readLine());

        int[][] alphabet = new int[S.length][26];
        for(int i = 0; i < alphabet.length; i++) {
            for(int j = 0; j < 26; j++) {
                if(i == 0) {
                    alphabet[i][(int)S[i].charAt(0)-97] = 1;
                    break;
                }
                else {
                    if(((int)S[i].charAt(0)-97) == j) {
                        alphabet[i][j] = alphabet[i-1][j] + 1;
                    }
                    else {
                        alphabet[i][j] = alphabet[i-1][j]; 
                    }
                }
            }
        }


        for(int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);
            int count = 0;
            
            if(l == 0) count = alphabet[r][(int)input[0].charAt(0)-97];
            else count = alphabet[r][(int)input[0].charAt(0)-97] - alphabet[l-1][(int)input[0].charAt(0)-97];

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
